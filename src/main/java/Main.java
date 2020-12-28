import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import me.tongfei.progressbar.ProgressBar;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) {
        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();
        try {
            Dictionary.loadDictionary();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Error Cannot load the dictionary.");
            return;
        }

        String sampleExcel = "";
        String outputPath = "";
        String batchPath = "";
        String batchName = "Batch 5"; // Don't forget to

        try {
            Path[] allFiles = FileUtils.getAllFiles(batchPath);
            Uploader.setOptions(batchName);
            Uploader.uploadAllAndSaveInDictionary(allFiles);
        }
        catch (Exception e){
            try {
                System.out.println(e.getMessage());
                e.printStackTrace();
                Dictionary.closeAndSave();
            } catch (IOException ioException) {
                System.out.println("Error Cannot save the dictionary.");
                System.out.println(e.getMessage());
                e.printStackTrace();
                return;
            }
        }


    }
}
/*
        for (Object entry : uploadResult.entrySet()) {
            System.out.println(entry);
        }
 */
