import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
/*
Saves:
original filename , secure_url, cloudName
 */
public class Dictionary {
    static String dictionaryPath = Constants.DictionaryPath;
    static FileWriter csvWriter;
    static Map<String, String> dictionary;
    static final int fileNameIdx = 0, linkIdx = 1;

    static {
        try {
            csvWriter = new FileWriter(dictionaryPath,true);
            loadDictionary();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Error Cannot load the dictionary.");
        }
    }

    public static void loadDictionary() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(dictionaryPath));
        dictionary = new HashMap<>();
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            dictionary.put(data[fileNameIdx], data[linkIdx]);
        }
        csvReader.close();
    }
    public static void add(Map uploadResult) throws IOException {
        String name = uploadResult.get("original_filename").toString() + "." + uploadResult.get("format");
        String url = uploadResult.get("secure_url").toString();
        dictionary.put(name,url);

        csvWriter.append(name).append(",").append(url).append(",").append(Uploader.getCloudName()).append("\n");
    }
    public static String getUrl(String fileName){
        return dictionary.getOrDefault(fileName,null);
    }
    public static void closeAndSave() throws IOException {
        csvWriter.flush();
        csvWriter.close();
    }
    public static void save() throws IOException {
        closeAndSave();
        loadDictionary();
    }
}
