import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Profile {
    protected String taskName;
    protected String batchPath, sampleExcel, outputPath;
    protected static final String PSDelimiter = Constants.PSDelimiter;
    protected static final String combinedFilename = "batch " + Constants.batchId + " combined";
    protected String sheetName;
    protected int start_row = 1;

    public Profile(String taskName, String batchPath, String sampleExcel, String outputPath, String sheetName) throws Exception {
        outputPath += ("\\" + taskName);

        this.taskName = taskName;
        this.batchPath = batchPath;
        this.sampleExcel = sampleExcel;
        this.outputPath = outputPath ;
        this.sheetName = sheetName;

        File directory = new File(outputPath);
        if (!directory.exists()){
            if(!directory.mkdirs())
                throw new Exception("Cannot make directory for output");
        }
    }

    public void run() throws Exception{
        List<String> directories = FileUtils.getDirectories(batchPath);
        Excel excel = new Excel(sampleExcel,outputPath,combinedFilename,sheetName,start_row);

        try (ProgressBar pb =new ProgressBarBuilder().setTaskName("Creating Files " + taskName)
                .setInitialMax(directories.size())
                .setStyle(ProgressBarStyle.UNICODE_BLOCK)
                .showSpeed()
                .build()) {

            for (String dir : directories) {
                if(!Constants.allInOneFile)
                    excel = new Excel(sampleExcel, outputPath, dir, sheetName, start_row);
                excel.fillRows(getDataDirectory(FileUtils.getFiles(batchPath + "//" + dir)));
                if(!Constants.allInOneFile)
                    excel.saveAndClose();
                pb.step();
            }
            excel.saveAndClose();
        }
    }

    protected abstract Map<Integer,String> getDataForRow(String firstFileName,String secondFileName,String name, Brand brand, Skin skin,String HOW_TO_URL);
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
            if(skin == null)
                throw new Exception("Error skin " + data[1] + " is not exist");

            String HOW_TO_URL = MobileAndSkinData.skinsData.get("HOW_TO").getURL();
            dataForDirectory.add(getDataForRow(curr,secondFileName,name,brand,skin,HOW_TO_URL));
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
        return "6.9 inches";
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
