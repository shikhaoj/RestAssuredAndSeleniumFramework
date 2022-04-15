package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Test {
    @org.testng.annotations.Test
    public void script()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.manage().window().maximize();
    }
}
