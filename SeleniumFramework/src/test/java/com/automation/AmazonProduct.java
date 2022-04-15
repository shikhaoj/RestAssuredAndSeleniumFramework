package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseClass;

public class AmazonProduct extends BaseClass {
    @Test
    public void product()
    {
//        WebDriverManager.chromedriver().setup();
        //driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung a71");
        //driver.findElement(By.id("nav-search-submit-button")).click();
        //driver.findElement(By.partialLinkText("Samsung Galaxy M32 5G (Slate Black, 8GB RAM, 128GB Storage)")).click();

       // driver.get("http://omayo.blogspot.com");
    }
}
