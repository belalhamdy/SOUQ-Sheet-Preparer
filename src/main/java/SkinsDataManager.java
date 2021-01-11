import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class SkinsDataManager {
    private static final String template = Constants.sampleSkinsData;
    private static String skinsDataPath = Constants.skinsDataPath;
    private static final String uploadDirectory = Constants.uploadSkinsDataDirectory;
    private static final String delimiter = Constants.TSVDelimiter;

    public static boolean validateSkinsData(){
        boolean ret = true;
        List<String> data = null;
        try {
            Uploader.setOptions("Packages");
            validateSkinsDataExistence();
            data = FileUtils.readLineByLine(skinsDataPath);
            uploadAndAddToList(data);

        }catch (Exception e){
            System.out.println(e.getMessage());
            ret = false;
        }
        finally {
            if(data != null) {
                try {
                    FileUtils.saveLineByLine(skinsDataPath,data);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ret = false;
                }
            }
        }
        return ret;
    }
    private static void uploadAndAddToList(List<String> data) throws Exception {
        try(ProgressBar pb = new ProgressBarBuilder().setTaskName("Uploading Skins data")
                .setInitialMax(data.size())
                .setStyle(ProgressBarStyle.UNICODE_BLOCK)
                .showSpeed()
                .build()){
            for(int i = 0 ; i < data.size() ; ++i){
                String[] curr = data.get(i).split(delimiter);
                // link is in cell 7
                if(curr.length <= 6) {
                    String filename = curr[0];
                    Map uploadResult = Uploader.uploadImage(uploadDirectory + "\\" + filename + ".jpg");
                    String url = uploadResult.get("secure_url").toString();
                    String newData = data.get(i) + delimiter + url;
                    data.set(i, newData);
                }
                pb.step();
            }
        }catch (Exception e){
            throw new Exception("Error in uploading data");
        }

    }
    private static void validateSkinsDataExistence() throws Exception {
        File f = new File(skinsDataPath);
        if(!f.exists() || f.isDirectory()) {
            try {
                skinsDataPath = FileUtils.copyFile(template,Constants.skinsDataDirectory,Constants.skinsDataFile);
            } catch (IOException e) {
                throw new Exception("Cannot copy skins data template");

            }
        }
    }

}
