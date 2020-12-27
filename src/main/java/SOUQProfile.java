import java.util.List;
import java.util.Map;

public class SOUQProfile extends Profile {
    Map<String, Double> screenSizesDictionary;
    Map<String,String> compatibleBrandNames;
    private final double defaultScreenSize = 0.0; // TODO: update this value
    private int numberOfDefaultScreenSizeUsed; // Print it to validate that you used the whole dictionary


    public SOUQProfile(String batchPath, String sampleExcel, String outputPath, Map<String, Double> screenSizesDictionary) {
        super(batchPath, sampleExcel, outputPath);
        this.screenSizesDictionary = screenSizesDictionary;
        constructCompatibleBrandNames();
    }

    @Override
    public void run() {
        numberOfDefaultScreenSizeUsed = 0;
    }
    private void constructCompatibleBrandNames(){
        compatibleBrandNames.put("iphone","Apple");
        compatibleBrandNames.put("realme","Oppo");
        compatibleBrandNames.put("htc","HTC");

        compatibleBrandNames.put("honor","Honor");
        compatibleBrandNames.put("nokia","Nokia");
        compatibleBrandNames.put("oppo","Oppo");
        compatibleBrandNames.put("oneplus","OnePlus");
        compatibleBrandNames.put("samsung","Samsung");
        compatibleBrandNames.put("vivo","Vivo");
        compatibleBrandNames.put("xiaomi","Xiaomi");
        compatibleBrandNames.put("google","Google");
        compatibleBrandNames.put("infinix","Infinix");
        compatibleBrandNames.put("motorola","Motorola");
        compatibleBrandNames.put("huawei","Huawei");
    }
    private String getCompatibleBrandName(String name) throws Exception {
        String ret = compatibleBrandNames.get(name);
        if(ret == null) throw new Exception("The brand " + name + " is not in the dictionary.");
        return ret;
    }
    private String getScreenSizeName(Double val) throws Exception {
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
    }
    private String getScreenSize(String phoneName) throws Exception {
        Double val = screenSizesDictionary.get(phoneName);
        if(val == null){
            numberOfDefaultScreenSizeUsed++;
            val = defaultScreenSize;
        }
        return getScreenSizeName(val);
    }

    // takes list of files and returns list every item there is a map for every column and its value
    public List<Map<Integer,String>> getDataForRow(List<String> files){
        // TODO: Core function
        return null;
    }
}
