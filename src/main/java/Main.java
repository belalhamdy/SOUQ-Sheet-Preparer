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
        // Do not forget to change every comma in the uploaded data with dot

        String sampleExcel = "";
        String outputPath = "";
        String batchPath = "S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5";


        System.out.println(MobileAndSkinData.skinsData.get("se201wcp").getTitleAR());

        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();
        Uploader.UploadAll(batchPath); // for uploading batch


    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
 */
