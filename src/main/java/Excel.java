import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Excel {
    Workbook workbook;
    FileOutputStream fileOutputStream;
    String sheetName;
    int currRow;

    public Excel(String profilePath, String directory, String filename, String sheetName, int startRow) throws IOException {
        String filePath = FileUtils.copyFile(profilePath, directory, filename);
        initXlsx(filePath);
        this.sheetName = sheetName;
        currRow = startRow; // first row is the header
    }

    private void initXlsx(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        fileOutputStream = new FileOutputStream(filePath, false);
        workbook = WorkbookFactory.create(inputStream);
        inputStream.close();
    }

    public void saveAndClose() throws IOException {
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    private void goToNextRow() {
        ++currRow;
    }

    public void fillCurrentRow(Map<Integer, String> map) {
        Row row = workbook.getSheet("File").getRow(currRow);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int colIdx = entry.getKey();
            String value = entry.getValue();
            row.createCell(colIdx).setCellValue(value);
        }
        goToNextRow();
    }

}
