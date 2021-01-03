import java.util.HashMap;
import java.util.Map;

public class JumiaProfile extends Profile {
    private final String description = "<ul>\n" +
            "    <li>OZO skins, the effective way to protect your phone back</li>\n" +
            "    <li>High Quality material, good adhesive components, perfect texture, and no bubbles.</li>\n" +
            "    <li>Elegant, modern and original.</li>\n" +
            "    <li>Slim, light with perfect fit Anti-scratch Anti-fingerprint, environmentally-friendly material protects your Phone from daily scratches, dust, normal signs of wear, and danger of slipping out of hand.</li>\n" +
            "    <li>Easy to Install According to the instruction manual, you could install it by yourself easily.</li>\n" +
            "    <li>Easy to remove so you can change style and design.</li>\n" +
            "    <li>This wrap leaves no sticky residue when You remove it.</li>\n" +
            "</ul>";

    private Long SKU;

    public JumiaProfile(String batchPath, String sampleExcelPath, String outputPath, long startSKU) throws Exception {
        super("Jumia", batchPath, sampleExcelPath, outputPath, "Upload Template");
        start_row = 1;
        SKU = startSKU;
    }

    public Long getSKU() {
        return SKU;
    }

    @Override
    protected Map<Integer, String> getDataForRow(String firstFileName, String secondFileName, String name, Brand brand, Skin skin) {
        SKU += 1;
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
            put(24, description); // Description #16
            put(25, description); // DescriptionArEG #243
            put(26, description); // ShortDescription #128
            put(27, description); // ShortDescriptionArEG #244
            put(32, "..."); // Variation #436

            put(66, skin.getURL()); // MainImage #IM1
            put(67, Dictionary.getUrl(secondFileName)); // Image2 #IM2
            put(68, Dictionary.getUrl(firstFileName)); // Image3 #IM3
            put(69, HOW_TO_URL); // Image4 #IM4

        }};
    }
}
