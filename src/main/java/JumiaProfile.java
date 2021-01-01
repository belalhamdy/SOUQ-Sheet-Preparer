import java.util.HashMap;
import java.util.Map;

public class JumiaProfile extends Profile {
    private Long SKU;
    public JumiaProfile(String batchPath, String sampleExcelPath, String outputPath, long startSKU) throws Exception {
        super("Jumia",batchPath, sampleExcelPath, outputPath,"Upload Template");
        start_row = 1;
        SKU = startSKU;
    }

    public Long getSKU() {
        return SKU;
    }

    @Override
    protected Map<Integer,String> getDataForRow(String firstFileName, String secondFileName, String name, Brand brand, Skin skin){
        SKU+=1;
        // TODO: update jumia data
        return new HashMap<>() {{
            put(0, skin.getTitleEN() + " " + name); // Name #5:SMQ
            put(1, "OZO Skins"); // Brand #6:AAQJnA
            put(3, "1008166 - Phones & Tablets / Accessories / Cases / Stickers"); // PrimaryCategory #1
            put(7, skin.getName()); // Model #30
            put(8, "N/A"); // Color #79
            put(9, skin.getTitleEN() + " " + name); // NameArEG #242
            put(11, "99"); // Price #9
            put(14, SKU.toString()); // SellerSku #23
            put(17, "5"); // Quantity #253
            put(19, "0.3"); // ProductWeight #53
            put(21, "N/A"); // MainMaterial #82
            put(24,""); // Description #16 TODO
            put(25,""); // DescriptionArEG #243 TODO
            put(26,""); // ShortDescription #128 TODO
            put(27,""); // ShortDescriptionArEG #244 TODO
            put(32,""); // Variation #436 TODO
            put(66,skin.getURL()); // MainImage #IM1
            put(67,Dictionary.getUrl(secondFileName)); // Image2 #IM2
            put(68,Dictionary.getUrl(firstFileName)); // Image3 #IM3
            put(69,HOW_TO_URL); // Image4 #IM4
        }};
    }
}
