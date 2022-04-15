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

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Cleartrip {

    // static {
    //System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
    // }
    @Test

    public static void trip(){
        boolean bool_value;
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get("https://www.cleartrip.com/");
        bool_value=driver.findElement(By.xpath("(//span[@class=\"radio__circle bs-border bc-neutral-500 bw-1 ba\"])[1]")).isEnabled();
        System.out.println(bool_value);
        driver.findElement(By.xpath("(//span[@class=\"radio__circle bs-border bc-neutral-500 bw-1 ba\"])[2]")).click();
        WebElement p = driver.findElement(By.xpath("(//select[@class=\"default-select bc-neutral-100 bg-transparent h-8 br-4 pl-2 p-relative zIndex-5\"])[1]"));
        Select adult=new Select(p);
        adult.selectByIndex(5);

        WebElement c = driver.findElement(By.xpath("(//select[@class='default-select bc-neutral-100 bg-transparent h-8 br-4 pl-2 p-relative zIndex-5'])[2]"));
        Select child=new Select(c);
        child.selectByValue("3");

        WebElement i = driver.findElement(By.xpath("(//select[@class='default-select bc-neutral-100 bg-transparent h-8 br-4 pl-2 p-relative zIndex-5'])[3]"));
        Select infant=new Select(i);
        infant.selectByVisibleText("1");



    }
}
