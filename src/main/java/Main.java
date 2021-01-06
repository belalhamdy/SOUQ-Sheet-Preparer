import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    static int batchNumber = 6;

    static String DictionaryPath = "Dictionaries\\Batch " + batchNumber + ".csv";
    static String sampleSOUQExcel = "SampleSOUQ.xlsx";
    static String sampleJumiaExcel = "SampleJumia.xlsx";
    static String outputPath = "Excel Out\\Batch " + batchNumber;
    static String batchPath = "S:\\work\\armor\\Skins Project\\Final\\Out\\Batch " + batchNumber;
    static String HowToURL = "https://res.cloudinary.com/ozoskins/image/upload/v1609628223/Constants/How_to_zqhkcn.jpg";
    static String PSDelimiter = "-";
    static String skinsDataPath = "SkinsData.tsv";

    public static void main(String[] args) {
        // Do not forget to change every comma in the uploaded data with dot


        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();

        Uploader.UploadAll(batchPath); // for uploading batch

        try {
            SOUQProfile souqProfile = new SOUQProfile(batchPath, sampleSOUQExcel, outputPath);
            souqProfile.run();

        } catch (Exception e) {
            System.out.println("Error In SOUQ\n" + e.getMessage());
            e.printStackTrace();
        }

        // Do not forget to update the start SKU every time you produce new batch
        long SKU = 401092;
        try {
            JumiaProfile jumiaProfile = new JumiaProfile(batchPath, sampleJumiaExcel, outputPath,SKU);
            jumiaProfile.run();
            System.out.println("Next SKU: " + jumiaProfile.getSKU());

        } catch (Exception e) {
            System.out.println("Error In Jumia\n" + e.getMessage());
            e.printStackTrace();
        }

    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
*/
