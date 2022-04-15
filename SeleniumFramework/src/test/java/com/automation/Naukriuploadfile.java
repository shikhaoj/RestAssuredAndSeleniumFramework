package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjectmodel.nuakridownloadandupload.Homepage;
import pageobjectmodel.nuakridownloadandupload.Loginpage;
import pageobjectmodel.nuakridownloadandupload.Resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;


public class Naukriuploadfile {

    @Test
    public void upload() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Loginpage loginpage=new Loginpage(driver);
        Homepage homepage=new Homepage(driver);
        Resume resume=new Resume(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
        loginpage.getMainLoginButton().click();
        //driver.findElement(By.cssSelector("a#login_Layer>div")).click();
        FileInputStream fileInputStream =new FileInputStream("./Data/uploadfile.xlsx");
        Workbook wb = WorkbookFactory.create(fileInputStream);
        String user= wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
        String password = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
        WebDriverWait wait=new WebDriverWait(driver,10);
        //driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys(user);
        loginpage.getEmail().sendKeys(user);
        loginpage.getUserpassword().sendKeys(password);
        //driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getLoginButton())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']"))).click();
        homepage.getUpdateProfileButton().click();

        //driver.findElement(By.xpath("//div[text()='UPDATE PROFILE']")).click();
        File path = new File("./Data/resume.pdf");
        String absPath = path.getAbsolutePath();
        System.out.println(absPath);
        resume.getUploadResume().sendKeys(absPath);
        //driver.findElement(By.id("attachCV")).sendKeys(absPath);
    }
}

