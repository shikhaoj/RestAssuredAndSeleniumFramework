package com.qa.api.gorest.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    public static Workbook workbook;
    public static Sheet sheet;
    public static String TESTDATA_SHEET_PATH = "/home/raramuri/IdeaProjects/REST_Assured_Framework/src/main/java/com/qa/api/gorest/testdata/GoRestTestData.xlsx";

    public static Object[][] getTestData(String sheetName) throws IOException {

        //FileInputStream will make the connection with the excel file
        FileInputStream fileInputStream=new FileInputStream(TESTDATA_SHEET_PATH);
        //And then workbook.create() method will create a local copy inside the java memory
        workbook=WorkbookFactory.create(fileInputStream);
        sheet=workbook.getSheet(sheetName);
        Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0;i<sheet.getLastRowNum();i++){
            for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }

}
