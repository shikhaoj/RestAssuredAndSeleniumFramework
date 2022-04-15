package com.automation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

public class Iframes {

    @Test
    public void frames() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
        driver.findElement(By.id("iFrame")).click();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.lazyloaded")));

        //WebElement iframe = driver.findElement(By.cssSelector("iframe.lazyloaded"));
        //WebElement iframe = driver.findElement(By.cssSelector("ins.adsbygoogle.adsbygoogle-noablate>ins#aswift_1_expand>ins#aswift_1_anchor>iframe#aswift_1"));
        //driver.switchTo().frame(iframe);
        WebElement s = driver.findElement(By.cssSelector("span#current_filter"));

        Actions mouseAction =new Actions(driver);
        mouseAction.moveToElement(s).perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("li#menu-item-1513")).click();
        driver.findElement(By.cssSelector("div.ns-35uqy-e-17")).click();
       // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dismiss-button"))).click();
        //driver.findElement(By.cssSelector("#dismiss-button")).click();

    }
}