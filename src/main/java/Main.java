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
        String sampleExcel = "";
        String outputPath = "";
        String batchPath = "S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5";



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

        Uploader.UploadAll(batchPath); // for uploading batch


    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
 */
