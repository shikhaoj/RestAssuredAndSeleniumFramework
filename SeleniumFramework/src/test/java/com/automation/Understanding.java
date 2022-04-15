package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Understanding {
    @Test

    public static void method(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();

        driver.manage().window().maximize();

        //driver.get("https://www.amazon.in/");
        //String window= driver.getTitle();
        //System.out.println(window);
        //String mainWin = driver.getWindowHandle();
        //System.out.println(driver.getTitle());
        //System.out.println(mainWin);

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple iphone 13");
        //driver.findElement(By.id("nav-search-submit-button")).click();

        //driver.findElement(By.partialLinkText("Apple iPhone 13 (128GB) - Starlight")).click();
        //String parent= driver.getWindowHandle();

        Set<String>s=driver.getWindowHandles();
        System.out.println(s);
        //Iterator<String> I1=s.iterator();
        //String child_window=I1.next();
        //String child= I1.next();
        //System.out.println(child_window);

        //System.out.println(child);

        //String child3= I1.next();
        //System.out.println(child_window);

        //System.out.println(child3);
        //if(window==)
        //driver.close();
        //driver.switchTo().window(child);
        //System.out.println(driver.getCurrentUrl());

        //driver.close();
        //driver.switchTo().window(child);
        //System.out.println(driver.getCurrentUrl());
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-button")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.findElement(By.id("add-to-cart-button")).click();

    }
}
