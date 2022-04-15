package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Robot;

public class Makemytrip {

    // static {
    //System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
    // }
    @Test

    public static void trip() throws AWTException, InterruptedException {
        boolean bool_value;
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        Robot r= new Robot();
        r.keyPress(40);
        r.keyRelease(40);

        r.keyPress(40);
        // Thread.sleep(200000000);

        r.keyRelease(40);

        driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Fri Apr 01 2022']")).click();

    }
}
