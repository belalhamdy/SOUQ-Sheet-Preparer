import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static List<String> readLineByLine(String file) throws Exception {
        List<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String row;
            while ((row = reader.readLine()) != null) {
                ret.add(row);
            }
            reader.close();
        } catch (Exception e) {
            throw new Exception("Error in reading file line by line");
        }
        return ret;
    }

    public static void saveLineByLine(String file, List<String> data) throws Exception {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (String d : data) {
                bw.write(d);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            throw new Exception("Cannot save file line by line");
        }
    }
}
