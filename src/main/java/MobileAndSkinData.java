import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class MobileAndSkinData {
    static Map<String, Skin> skinsData;
    static String skinsDataPath = "SkinsData.tsv";
    static {
        try {
            loadSkinsData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadSkinsData() throws IOException {
        BufferedReader tsvReader = new BufferedReader(new FileReader(skinsDataPath));
        String delimiter = "\t";
        skinsData = new HashMap<>();
        String row;
        while ((row = tsvReader.readLine()) != null) {
            String[] data = row.split(delimiter);
            Skin curr = new Skin(data[1],data[2],data[3],data[4],data[5],data[6]);
            skinsData.put(data[0],curr);
        }
        tsvReader.close();
    }

}
