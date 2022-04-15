package com.automation;

import java.util.Date;
import java.text.SimpleDateFormat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.makemytrip.Flights;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.awt.*;


public class Makemytripsystemdate {
    @Test
    public void booktickets() throws AWTException, InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        Robot robot=new Robot();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        Flights flights=new Flights(driver);
        WebDriverWait wait=new WebDriverWait(driver,30);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        flights.getRootElement().click();
        wait.until(ExpectedConditions.elementToBeClickable(flights.getSource())).click();
        flights.getFromPlaceholder().sendKeys("BHO");
        wait.until(ExpectedConditions.textToBePresentInElement(flights.getVisibilityOfSource(),"Bhopal, India"));
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        flights.getToPlaceholder().sendKeys("BKK");
        wait.until(ExpectedConditions.textToBePresentInElement(flights.getVisibilityOfDestination(),"Bangkok, Thailand"));
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy");
        String str = formatter.format(date);
        System.out.println(str);
        String s="//div[@aria-label=";
        System.out.println(s+"'"+str+"']");
        driver.findElement(By.xpath(s+"'"+str+"']")).click();
        String actualTitle= driver.getTitle();
        String expectedTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
