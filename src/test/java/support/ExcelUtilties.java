package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilties {

    public static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    static int sheetCount;
    static XSSFCellStyle cellStyle;
    static File src;

    public static Object[][] getTestDataMap(File filePath, String SheetName) {
        Object[][] obj = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(filePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int lastRowNum = ExcelWSheet.getLastRowNum();
            int lastCellNum = ExcelWSheet.getRow(0).getLastCellNum();
            obj = new Object[lastRowNum][1];


            for (int i = 0; i < lastRowNum; i++) {
                Map<Object, Object> datamap = new HashMap<>();
                for (int j = 0; j < lastCellNum; j++) {
                    datamap.put(ExcelWSheet.getRow(0).getCell(j).toString(), ExcelWSheet.getRow(i + 1).getCell(j).toString());
                }
                obj[i][0] = datamap;
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    public static Object[][] getTestDataMapnew(File filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name '" + sheetName + "' not found.");
            }

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    
    public static Object[][] getTestDataMapNew(File file, String sheetName) {
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            Object[][] data = new Object[rowCount][];
            
            for (int i = 0; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) { // Check if row is not null
                    int cellCount = row.getPhysicalNumberOfCells();
                    data[i] = new Object[cellCount];
                    for (int j = 0; j < cellCount; j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null) { // Check if cell is not null
//                            data[i][j] = cell.toString(); // or whatever conversion you need
                        	data[i][j]=getCellValueAsString((XSSFCell) cell);
                        } else {
                            data[i][j] = ""; // Handle null cell
                        }
                    }
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getCellValueAsString(XSSFCell cell) {
        if (cell == null) {
            return ""; // Return empty string if cell is null
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue(); // For String cells
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()); // For Numeric cells
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // For Boolean cells
            case FORMULA:
                return cell.getCellFormula(); // For Formula cells (returns the formula as a string)
            case BLANK:
                return ""; // For Blank cells
            default:
                return ""; // Default case for other types
        }
    }
    
    // To Write the Data To the Excel.
    
    @SuppressWarnings("resource")
    public static void writeData(String sheetName, String filepath, String Result, int columnName, int Rowcount)
        throws IOException {
        Workbook Workbook = null;
        FileOutputStream fos;
     	Row row2;
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = Workbook.getSheet(sheetName);
       	if(sheet.getRow(Rowcount) != null) {
            row2 = sheet.getRow(Rowcount);
            }
        else {
            row2 = sheet.createRow(Rowcount);
        }
        row2.createCell(columnName).setCellValue(Result);
        fos = new FileOutputStream(filepath);
        Workbook.write(fos);
        fos.close();
        System.out.println("END OF WRITING DATA IN EXCEL");
    }

}
