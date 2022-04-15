package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjectmodel.nuakridownloadandupload.Homepage;
import pageobjectmodel.nuakridownloadandupload.Loginpage;
import pageobjectmodel.nuakridownloadandupload.Resume;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.awt.*;


public class Naukridownloadfile {

    @Test
    public void download() throws IOException, InterruptedException, AWTException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Homepage homepage=new Homepage(driver);
        Loginpage loginpage=new Loginpage(driver);
        Resume resume=new Resume(driver);
        Robot r=new Robot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
        loginpage.getMainLoginButton().click();
        //driver.findElement(By.cssSelector("a#login_Layer>div")).click();
        FileInputStream fileInputStream =new FileInputStream("./Data/propertyfile.properties");
        Properties properties=new Properties();
        properties.load(fileInputStream);
        String userName=properties.getProperty("user");
        String userPassword=properties.getProperty("password");
        System.out.println(properties.getProperty("user"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        loginpage.getEmail().sendKeys(userName);
        //driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys(userName);
        loginpage.getUserpassword().sendKeys(userPassword);
        //driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(userPassword);
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getUserpassword())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getLoginButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']"))).click();
        homepage.getUpdateProfileButton().click();
        //driver.findElement(By.xpath("//div[text()='UPDATE PROFILE']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(resume.getDownloadButton())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.right.download>i.icon"))).click();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyRelease(18);
        r.keyPress(KeyEvent.VK_S);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(10);
    }
}

