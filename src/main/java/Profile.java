import me.tongfei.progressbar.ProgressBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Profile {
    protected String batchPath, sampleExcel, outputPath;
    protected static final String HOW_TO_URL = "https://res.cloudinary.com/belalhamdy/image/upload/v1609231459/Constants/How_to_jjvtkw.jpg";
    protected static final String PSDelimiter = "-";
    protected int start_row = 1;

    public Profile(String batchPath, String sampleExcel, String outputPath) {
        this.batchPath = batchPath;
        this.sampleExcel = sampleExcel;
        this.outputPath = outputPath;
    }

    public void run() throws Exception{
        List<String> directories = FileUtils.getDirectories(batchPath);
        Excel excel;
        try (ProgressBar pb = new ProgressBar("Creating Files ", directories.size())) {
            for (String dir : directories) {
                excel = new Excel(sampleExcel, outputPath, dir, "File", start_row);
                excel.fillRows(getDataDirectory(FileUtils.getFiles(batchPath + "//" + dir)));
                excel.saveAndClose();
                pb.step();
            }
        }
    }

    protected abstract Map<Integer,String> getDataForRow(String firstFileName,String secondFileName,String name, Brand brand, Skin skin);
    // takes list of files and returns list every item there is a map for every column and its value
    protected List<Map<Integer, String>> getDataDirectory(List<String> files) throws Exception{
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
            Skin skin = MobileAndSkinData.skinsData.get(data[1]);


            dataForDirectory.add(getDataForRow(curr,secondFileName,name,brand,skin));
        }
        return dataForDirectory;
    }
    protected String getScreenSizeNameAR() {
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
    protected String getScreenSizeName() {
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
}
