package com.automation;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;

public class Uploadfilehardcode {
    @Test
    public void uploadFile() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sodapdf.com/txt-to-pdf/");
        driver.findElement(By.cssSelector("label.btn-choose")).click();
        File file=new File("Downloads/Assignment3.txt");
        String s= file.getAbsolutePath();
        driver.findElement(By.cssSelector("label.btn-choose")).sendKeys(s);
    }
}
