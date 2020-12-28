import me.tongfei.progressbar.ProgressBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SOUQProfile extends Profile {
    private static final String PSDelimiter = "-";


    public SOUQProfile(String batchPath, String sampleExcelPath, String outputPath) {
        super(batchPath, sampleExcelPath, outputPath);
    }

    @Override
    public void run() throws Exception {
        List<String> directories = FileUtils.getDirectories(batchPath);
        Excel excel;
        try (ProgressBar pb = new ProgressBar("Creating Files ", directories.size())) {
            for (String dir : directories) {
                excel = new Excel(sampleExcel, outputPath, dir, "File", 1);
                excel.fillRows(getDataDirectory(FileUtils.getFiles(batchPath + "//" + dir)));
                excel.saveAndClose();
                pb.step();
            }
        }

    }


    private String getScreenSizeName() {
        return "6 to 6.9 inches";
        /*
        if(val > 8.9) throw new Exception("Screen Size " + val +" is very large please review it.");
        else if(val >= 8) return "8 to 8.9 inches";
        else if(val >= 7) return "7 to 7.9 inches";
        else if(val >= 6) return "6 to 6.9 inches";
        else if(val >= 5.6) return "5.6 to 6 inches";
        else if(val >= 5.1) return "5.1 to 5.5 inches";
        else if(val >= 4.6) return "4.6 to 5 inches";
        else if(val >= 4.1) return "4.1 to 4.5 inches";
        else if(val >= 3.6) return "3.6 to 4 inches";
        else if(val >= 3.1) return "3.1 to 3.5 inches";
        else return "Up to 3 inches";
         */
    }

    private String getScreenSizeNameAR() {
        return "6.9 انش";
        /*
        if(val > 8.9) throw new Exception("Screen Size " + val +" is very large please review it.");
        else if(val >= 8) return "8 to 8.9 inches";
        else if(val >= 7) return "7 to 7.9 inches";
        else if(val >= 6) return "6 to 6.9 inches";
        else if(val >= 5.6) return "5.6 to 6 inches";
        else if(val >= 5.1) return "5.1 to 5.5 inches";
        else if(val >= 4.6) return "4.6 to 5 inches";
        else if(val >= 4.1) return "4.1 to 4.5 inches";
        else if(val >= 3.6) return "3.6 to 4 inches";
        else if(val >= 3.1) return "3.1 to 3.5 inches";
        else return "Up to 3 inches";
         */
    }

    // takes list of files and returns list every item there is a map for every column and its value
    private List<Map<Integer, String>> getDataDirectory(List<String> files) throws Exception {
        List<Map<Integer, String>> dataForDirectory = new ArrayList<>();
        for (String curr : files) {
            String[] data = curr.split(PSDelimiter);

            // work only on v files and deduct the h file
            if (!data[data.length - 1].contains("v"))
                continue;
            StringBuilder secondFileNameBuilder = new StringBuilder();
            for (int i = 0; i < data.length - 1; ++i)
                secondFileNameBuilder.append(data[i]).append('-');
            secondFileNameBuilder.append("h.jpg");

            String secondFileName = secondFileNameBuilder.toString();

            String name = data[0];
            Brand brand = new Brand(data[0].split(" ")[0]);
            // TODO: in the next batch check for name of sv524gsp in the TSV file in the first column (you may find the correct one inside SOUQ Excel folder)
            Skin skin = MobileAndSkinData.skinsData.get(data[1]);
            // TODO: place images here (PACKAGE URL)
            // TODO: Update in TSV the package links
            String first = Dictionary.getUrl(curr);
            String second = Dictionary.getUrl(secondFileName);
            String images = "PACKAGE" + "\n" + Dictionary.getUrl(curr) + "\n" + Dictionary.getUrl(secondFileName) + "\n" + skin.getName() + "\n";

            Map<Integer, String> rowData = new HashMap<>() {{
                put(0, "517"); // Id type item
                put(2, skin.getTitleEN() + " " + name); // Product Title #6
                put(3, "OZO"); // Brand #7
                put(4, skin.getDescriptionEN()); // Description #9
                put(5, "N/A"); // Manufacturer Number #53
                put(6, skin.getType()); // Type #5700
                put(7, brand.getBrandName()); // Compatible Brands #5705
                put(8, getScreenSizeName()); // Compatible Screen Size #6426
                put(9, skin.getTitleAR()); // Product Title(AR) #100006
                put(10, "اوزو"); // Brand(AR) #100007
                put(11, skin.getDescriptionAR()); // Description(AR) #100009
                put(12, skin.getTypeAR()); // Type(AR) #105700
                put(13, brand.getBrandNameAR()); // Compatible Brands(AR) #105705
                put(14, getScreenSizeNameAR()); // Compatible Screen Size(AR) #106426
                put(15, "0"); // Are batteries needed to power the product or is this product a battery(AR) #106745
                put(16, "0"); // Are batteries needed to power the product or is this product a battery #6745
                put(17, "NO"); // Is this a Dangerous Good or a Hazardous Material, Substance or Waste that is regulated for transportation, storage, and/or disposal? #6746
                put(18, "NO"); // Is this a Dangerous Good or a Hazardous Material, Substance or Waste that is regulated for transportation, storage, and/or disposal?(AR) #106746
                put(20, images); // Images
                put(23, "iqshop"); // Seller Username
                put(25, "YES"); // Active
                put(26, "99"); // Listing Price
                put(27, "5"); // Stock Quantity
                put(29, "C"); // Handling Time
                put(72, "11111111111"); // External Product ID Type #6825
            }};
            dataForDirectory.add(rowData);
        }
        return dataForDirectory;
    }
}
