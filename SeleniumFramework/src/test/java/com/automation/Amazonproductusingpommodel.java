package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjectmodel.amazonpommodel.Amazonhomepage;
import pageobjectmodel.amazonpommodel.Productspecificpage;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Amazonproductusingpommodel {

    // static {
    //System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
    // }
    @Test

    public static void method(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        Amazonhomepage amazonhomepage=new Amazonhomepage(driver);
        Productspecificpage productspecificpage=new Productspecificpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
        //String window= driver.getTitle();
        //System.out.println(window);
        String mainWin = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        System.out.println(mainWin);
        amazonhomepage.getSearchBox().sendKeys("apple iphone 13");

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple iphone 13");
        amazonhomepage.getSubmitButton().click();
        //driver.findElement(By.id("nav-search-submit-button")).click();
        amazonhomepage.getProductTypeOne().click();
        //driver.findElement(By.partialLinkText("Apple iPhone 13 (512GB) - Starlight")).click();
        //String parent= driver.getWindowHandle();

        Set<String>s=driver.getWindowHandles();
        System.out.println(s);
        Iterator<String> I1=s.iterator();
        String child_window=I1.next();
        String child= I1.next();
        System.out.println(child_window);

        System.out.println(child);

        //String child3= I1.next();
        //System.out.println(child_window);

        //System.out.println(child3);
        //if(window==)
        //driver.close();
        //driver.switchTo().window(child);
        System.out.println(driver.getCurrentUrl());

        //driver.close();
        driver.switchTo().window(child);
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(productspecificpage.getAddToCartButton())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-button")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.findElement(By.id("add-to-cart-button")).click();
        //driver.findElement(By.id("add-to-cart-button")).click();
        driver.switchTo().window(child_window);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-button")));
      //  driver.findElement(By.partialLinkText("Apple iPhone 13 (512GB) - Starlight")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".img")));
        //driver.findElement(By.className("imgSwatch")).click();

    }
}
