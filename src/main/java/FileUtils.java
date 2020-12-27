import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static Path toPath(String fileName) {
        return Paths.get(fileName);
    }

    public static String copyFile(String source, String destinationDirectory, String newFileName) throws IOException {
        String destination = destinationDirectory + newFileName;
        Files.copy(toPath(source), toPath(destination), StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
