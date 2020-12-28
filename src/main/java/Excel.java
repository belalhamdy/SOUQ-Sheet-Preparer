import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Excel {
    private Workbook workbook;
    private FileOutputStream fileOutputStream;
    private final String sheetName;
    private int currRow;

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

    private void fillCurrentRow(Map<Integer, String> map) {
        Row row = workbook.getSheet(sheetName).getRow(currRow);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int colIdx = entry.getKey();
            String value = entry.getValue();
            row.createCell(colIdx).setCellValue(value);
        }
        goToNextRow();
    }
    public void fillRows(List<Map<Integer,String>> mapList){
        for (Map<Integer,String> curr : mapList){
            fillCurrentRow(curr);
        }
    }

}
