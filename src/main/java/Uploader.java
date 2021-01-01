import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public final class Uploader {
    static Cloudinary cloudinary;
    static Map<String, String> options = new HashMap<>();

    static {
        try {
            cloudinary = new Cloudinary(CloudinaryConfigs.getConfig());
        } catch (Exception e) {
            System.out.println("Unable to get the first config.");
            e.printStackTrace();
        }
    }

    private static void changeConfig() throws Exception {
        cloudinary = new Cloudinary(CloudinaryConfigs.getConfig());
    }

    private static void setOptions(String folderName) throws Exception {
        try {
            Map res = Uploader.cloudinary.api().createFolder(folderName, ObjectUtils.emptyMap());
            if (res.get("success").equals("true")) throw new Exception();
        } catch (Exception e) {
            throw new Exception("Cannot find or create the folder " + folderName);
        }
        options.put("folder", folderName);
        options.put("use_filename", "true");
    }

    public static String getCloudName() {
        return cloudinary.config.cloudName;
    }

    private static Map<String, String> uploadImage(String path) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(path, options);
        // if it cannot upload call change config
        return uploadResult;
    }

    public static void uploadAllAndSaveInDictionary(Path[] paths) throws IOException {
        // get the files that are not uploaded only
        List<Path> upload = new ArrayList<>();
        for (Path path : paths) {
            if (Dictionary.getUrl(path.getFileName().toString()) == null)
                upload.add(path);
        }
        if (upload.size() == 0)
            return;
        // upload the files that are not uploaded before only
        try (ProgressBar pb = new ProgressBarBuilder().setTaskName("Uploading")
                .setInitialMax(upload.size())
                .setStyle(ProgressBarStyle.UNICODE_BLOCK)
                .showSpeed()
                .build()) {
            for (Path path : upload) {
                String fileName = path.getFileName().toString();
                if (fileName.contains(",")) {
                    System.out.println("Cannot upload file " + fileName);
                } else {
                    Map uploadResult = uploadImage(path.toString());
                    Dictionary.add(uploadResult);
                }

                pb.step();
            }
        }
        Dictionary.closeAndSave();
    }

    public static void UploadAll(String batchPath) {
        try {
            String batchName = new File(batchPath).getName();
            Path[] allFiles = FileUtils.getAllFilesAndSubFiles(batchPath);
            setOptions(batchName);
            uploadAllAndSaveInDictionary(allFiles);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                e.printStackTrace();
                Dictionary.closeAndSave();
                System.out.println("saved");
                JOptionPane.showMessageDialog(null, "Error");
            } catch (IOException ioException) {
                System.out.println("Error Cannot save the dictionary.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
