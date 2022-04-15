package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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

public class Disabledelement {

    @Test
    public static void upload() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get("file:///home/raramuri/disabled.html");
        driver.findElement(By.id("id1")).sendKeys("shikha");
     // driver.findElement(By.id("id2")).sendKeys("rani");
     // JavascriptExecutor java = (JavascriptExecutor) driver;
    //  java.g
        RemoteWebDriver remote = (RemoteWebDriver) driver;
        remote.executeScript("document.getElementById('id2').value='jaishreeram'");
      //remote.executeScript("document.getElementById('id2').value='rani'");

        //document.getElementById(''d2).value='rani'
    }
}

