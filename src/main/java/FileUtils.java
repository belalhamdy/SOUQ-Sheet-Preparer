import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static Path toPath(String fileName) {
        return Paths.get(fileName);
    }

    public static String getExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i);
        }
        return extension;
    }

    public static String copyFile(String source, String destinationDirectory, String newFileName) throws IOException {
        String destination = destinationDirectory + "\\" + newFileName + getExtension(source);
        Files.copy(toPath(source), toPath(destination), StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }

    public static Path[] getAllFilesAndSubFiles(String directory) throws IOException {
        return Files.walk(Paths.get(directory)).filter(Files::isRegularFile).toArray(Path[]::new);
    }

    public static List<String> getFiles(String directory) {
        File[] listFiles = new File(directory).listFiles();
        List<String> ret = new ArrayList<>();
        if (listFiles != null) {
            for (File curr : listFiles) {
                if (curr.isFile())
                    ret.add(curr.getName());
            }
        }
        return ret;
    }

    public static List<String> getDirectories(String directory) {
        File[] listFiles = new File(directory).listFiles();
        List<String> ret = new ArrayList<>();
        if (listFiles != null) {
            for (File curr : listFiles) {
                if (curr.isDirectory())
                    ret.add(curr.getName());
            }
        }
        return ret;
    }
}
