import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        // Do not forget to change every comma in the uploaded data with dot
        // TODO: in the next patches replace the TSV file with the one inside SOUQ Excel

        String sampleExcel = "S:\\work\\armor\\Skins Project\\SOUQ Excel\\Sample.xlsx";
        String outputPath = "S:\\work\\armor\\Skins Project\\Final\\Excel Out\\Batch 5";
        String batchPath = "S:\\work\\armor\\Skins Project\\Final\\Out\\Batch 5";

        Logger.getRootLogger().setLevel(Level.INFO);
        BasicConfigurator.configure();

        //Uploader.UploadAll(batchPath); // for uploading batch

        try {
            SOUQProfile profile = new SOUQProfile(batchPath, sampleExcel, outputPath);
            profile.run();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
/*
for (Object entry : uploadResult.entrySet()) {
    System.out.println(entry);
}
*/
