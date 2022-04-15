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
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Robot.*;

public class Downloadpopupsfirefox {

    // static {
    //System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
    // }
    @Test

    public static void download() throws AWTException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();
        Robot robot=new Robot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/downloads/");
        driver.findElement(By.partialLinkText("4.1.0 (November 22, 2021)")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        //robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(9);
        //robot.keyRelease(18);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(10);

        driver.findElement(By.partialLinkText("4.1.2 (January 30, 2022)")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(40);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(10);

    }
}

