import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) throws IOException {
        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();
        Uploader.setOptions("Batch 5");
        Dictionary.loadDictionary();
        String sampleExcel = "";
        String outputPath = "";
        String batchPath = "";


        Path p = Paths.get("S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5\\huawei p30 lite\\huawei p30 lite-se205epp-h.jpg");
        File f = new File(String.valueOf(p));
        System.out.println(p.getFileName().toString());
        System.out.println(f.getName());
        System.out.println(f.getAbsolutePath());
        Map uploadResult = Uploader.uploadImage("S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5\\huawei p30 lite\\huawei p30 lite-se205epp-h.jpg");
        for (Object entry : uploadResult.entrySet()) {
            System.out.println(entry);
        }
        Dictionary.add(uploadResult,"belal");
        Dictionary.closeAndSave();

    }
}
