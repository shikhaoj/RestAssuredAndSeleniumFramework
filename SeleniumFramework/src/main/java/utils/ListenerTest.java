package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shikha Rani
 */

public class ListenerTest extends BaseClass implements ITestListener {
    /**
     *
     * @param result
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./Data/"+result.getMethod()+simpleDateFormat.format(d)+"screenshot.png");
        try {
            FileUtils.copyFile(SrcFile,DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

