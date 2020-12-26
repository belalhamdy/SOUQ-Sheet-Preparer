import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) throws IOException {
        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();

        Uploader.setOptions("Batch 5");
        Map uploadResult = Uploader.uploadImage("S:\\\\work\\\\armor\\\\Skins Project\\\\Final\\\\Out\\\\Batch 5\\\\honor 9x lite\\\\honor 9x lite-se201wcp-h.png");
        for (Object entry : uploadResult.entrySet()) {
            System.out.println(entry);
        }

    }
}
