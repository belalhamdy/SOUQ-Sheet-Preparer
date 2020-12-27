import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Dictionary {
    static String dictionaryPath = "";
    static FileWriter csvWriter;
    static Map<String, String> dictionary;
    static final int fileNameIdx = 0, linkIdx = 1;

    static {
        try {
            csvWriter = new FileWriter(dictionaryPath,true);
        } catch (IOException e) {
            e.printStackTrace();
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
    public static void add(Map uploadResult,String cloudName) throws IOException {
        String name = uploadResult.get("original_filename").toString();
        String url = uploadResult.get("secure_url").toString();
        dictionary.put(name,url);

        csvWriter.append(name).append(",").append(url).append(",").append(cloudName).append("\n");
    }
    public static void saveDictionary() throws IOException {
        csvWriter.flush();
        csvWriter.close();
    }
}
