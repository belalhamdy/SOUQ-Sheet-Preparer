import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    static String batchId = "6";
    // Do not forget to update the start SKU every time you produce new batch
    static long SKU = 401092;
    // Update these 2 values together
    static String skinsDataFile = "ozoskins1";
    static int skinsDataConfigIdx = 1; // idx in range [0,2]

    static int uploadConfigIdx = 2; // idx in range [2,[
    static int currCloudinaryConfig = skinsDataConfigIdx; // idx


    public static void main(String[] args) {
        // Do not forget to change every comma in the uploaded data with dot


        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();


        if(!SkinsDataManager.validateSkinsData()){
            System.out.println("Error in skins data file");
            return;
        }
        currCloudinaryConfig = uploadConfigIdx;
/*
        Uploader.UploadAll(Constants.batchDirectory); // for uploading batch

        try {
            SOUQProfile souqProfile = new SOUQProfile(Constants.batchDirectory, Constants.sampleSOUQExcel, Constants.outputDirectory);
            souqProfile.run();

        } catch (Exception e) {
            System.out.println("Error In SOUQ\n" + e.getMessage());
            e.printStackTrace();
            return;
        }

        try {
            JumiaProfile jumiaProfile = new JumiaProfile(Constants.batchDirectory, Constants.sampleJumiaExcel, Constants.outputDirectory, SKU);
            jumiaProfile.run();
            System.out.println("Next SKU: " + jumiaProfile.getSKU());

        } catch (Exception e) {
            System.out.println("Error In Jumia\n" + e.getMessage());
            e.printStackTrace();
            return;
        }
*/
    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
*/
