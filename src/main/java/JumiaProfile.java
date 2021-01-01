import java.util.HashMap;
import java.util.Map;

public class JumiaProfile extends Profile {
    public JumiaProfile(String batchPath, String sampleExcelPath, String outputPath) throws Exception {
        super(batchPath, sampleExcelPath, outputPath + "\\Jumia");
        start_row = 1;
    }

    @Override
    protected Map<Integer,String> getDataForRow(String firstFileName, String secondFileName, String name, Brand brand, Skin skin){
        // TODO: update jumia data
        String images = skin.getURL() + "\n" + Dictionary.getUrl(secondFileName) + "\n" + Dictionary.getUrl(firstFileName) + "\n" + HOW_TO_URL + "\n";

        return new HashMap<>() {{
            put(0, "517"); // Id type item
            put(2, skin.getTitleEN() + " " + name); // Product Title #6
            put(3, "OZO"); // Brand #7
            put(4, skin.getDescriptionEN()); // Description #9
            put(5, "N/A"); // Manufacturer Number #53
            put(6, skin.getType()); // Type #5700
            put(7, brand.getBrandName()); // Compatible Brands #5705
            put(8, getScreenSizeName()); // Compatible Screen Size #6426
            put(9, skin.getTitleAR() + " " + name); // Product Title(AR) #100006
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
            put(72, "111111111111"); // External Product ID Type #6825 (12 -> 1)
        }};
    }
}
