import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
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

    public static void setOptions(String folderName) {
        options.put("folder", folderName);
        options.put("use_filename", "true");
    }
    public static String getCloudName(){
        return cloudinary.config.cloudName;
    }
    public static Map<String, String> uploadImage(String path) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(path, options);
        // TODO: if it cannot upload call change config
        return uploadResult;
    }
}
