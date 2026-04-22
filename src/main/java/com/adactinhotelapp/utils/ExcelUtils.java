package com.adactinhotelapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    // Using DataFormatter is the best way to avoid NullPointerExceptions 
    // and correctly format numbers/dates as Strings.
    private static DataFormatter formatter = new DataFormatter();

    public static HashMap<String, String> getTestDataFromExcel(String testcaseName) {
        HashMap<String, String> testDataMap = new HashMap<>();
        
        // Use try-with-resources to ensure the file stream closes automatically
        try (FileInputStream fis1 = new FileInputStream("src/test/resources/testdata/excels/MasterTestData.xlsx");
             XSSFWorkbook wb = new XSSFWorkbook(fis1)) {

            XSSFSheet ws = wb.getSheet("regression");
            ArrayList<Row> testCaseRows = getTestCaseRows(ws, testcaseName);

            if (testCaseRows.size() < 2) {
                System.out.println("Warning: Test case '" + testcaseName + "' not found or missing data row.");
                return testDataMap;
            }

            Row headerRow = testCaseRows.get(0);
            Row dataRow = testCaseRows.get(1);

            // Loop through cells starting from index 1 (skipping the Test Case Name column)
            for (int i = 1; i < headerRow.getLastCellNum(); i++) {
                String key = formatter.formatCellValue(headerRow.getCell(i));
                String value = formatter.formatCellValue(dataRow.getCell(i));

                // Only add to map if the header (key) is not empty
                if (!key.isEmpty()) {
                    testDataMap.put(key, value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testDataMap;
    }

    private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testcaseName) {
        ArrayList<Row> testCaseRows = new ArrayList<>();

        for (int i = 0; i <= ws.getLastRowNum(); i++) {
            Row currentRow = ws.getRow(i);
            
            // Safety check: Row might be null, or the first cell (index 0) might be null
            if (currentRow != null && currentRow.getCell(0) != null) {
                String cellValue = formatter.formatCellValue(currentRow.getCell(0));
                if (cellValue.equalsIgnoreCase(testcaseName)) {
                    testCaseRows.add(currentRow);
                }
            }
        }
        return testCaseRows;
    }
}