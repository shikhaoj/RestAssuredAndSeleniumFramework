package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjectmodel.Testexceptions;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.awt.*;

public class Practicetestautomation {
    @Test
    public void practiceautomation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Testexceptions testexceptions=new Testexceptions(driver);
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement statement = testexceptions.getInstruction();
       // WebElement instruction = driver.findElement(By.cssSelector("p#instructions"));
        testexceptions.getAddButton().click();
        //driver.findElement(By.cssSelector("button#add_btn")).click();
        statement.isDisplayed();
    }
}
