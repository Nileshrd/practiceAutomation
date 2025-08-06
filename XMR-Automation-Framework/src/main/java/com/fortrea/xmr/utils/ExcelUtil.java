package com.fortrea.xmr.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {
    public static String getCellData(String fileName, String sheetName, int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream("./testdata/" + fileName)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            return sheet.getRow(rowNum).getCell(colNum).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
