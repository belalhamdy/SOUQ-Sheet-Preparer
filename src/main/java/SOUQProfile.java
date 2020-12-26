import java.util.Map;

public class SOUQProfile extends Profile {
    Map<String, Double> screenSizesDictionary;
    private final double defaultScreenSize = 0.0; // TODO: update this value
    private int numberOfDefaultScreenSizeUsed; // Print it to validate that you used the whole dictionary


    public SOUQProfile(String batchPath, String sampleExcel, String outputPath, Map<String, Double> screenSizesDictionary) {
        super(batchPath, sampleExcel, outputPath);
        this.screenSizesDictionary = screenSizesDictionary;
    }

    @Override
    public void run() {
        numberOfDefaultScreenSizeUsed = 0;
    }
    private String getScreenSizeName(Double val) throws Exception {
        if(val > 8.9) throw new Exception("Screen Size is very large please review it.");
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
}
