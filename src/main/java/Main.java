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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) {
        // Do not forget to change every comma in the uploaded data with dot

        String sampleExcel = "S:\\work\\armor\\Skins Project\\SOUQ Excel\\Sample.xlsx";
        String outputPath = "S:\\work\\armor\\Skins Project\\Final\\Excel\\Batch 5";
        String batchPath = "S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5";

        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();

        //Uploader.UploadAll(batchPath); // for uploading batch

        try {
            SOUQProfile profile = new SOUQProfile(batchPath, sampleExcel, outputPath);
            profile.run();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
*/
