package utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pageobjectmodel.flipkart.FlipkartProductPage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Shikha Rani
 */
public class ExcelUtilities extends BaseClass {
    /**
     *
     * @param path
     * @param row
     * @param cell
     * @param sheet
     * @throws IOException
     */
    public void write(String path,int row,int cell,int sheet) throws IOException {
        FlipkartProductPage flipkartproductpage=new FlipkartProductPage(driver);
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        for(int i=0;i<flipkartproductpage.getHighlights().size();i++){
            workbook.getSheetAt(sheet).getRow(row).getCell(cell).setCellValue(flipkartproductpage.getHighlights().get(i).getText());
            row++;
        }
        workbook.write(fileOutputStream);
        workbook.close();
    }
    /**
     *
     * @param path
     * @param sheet
     * @param row
     * @param cell
     * @return
     * @throws IOException
     */
    public String read(String path,int sheet,int row,int cell) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        Workbook book=WorkbookFactory.create(fis);
        String data=book.getSheetAt(sheet).getRow(row).getCell(cell).getStringCellValue();
        return data;
    }
}

