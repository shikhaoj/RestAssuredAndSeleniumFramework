package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageobjectmodel.flipkart.LoginPageFlipkart;
import java.awt.*;
import java.io.IOException;

/**
 * @author Shikha Rani
 */
public class BaseClass {
    public static WebDriver driver =null;
    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }
    @AfterClass
    public void closeBrowser() {
      driver.quit();
    }
    /**
     *
     * @throws AWTException
     * @throws IOException
     */
    @BeforeMethod
    public void login() throws AWTException, IOException {
        LoginPageFlipkart loginpageflipkart=new LoginPageFlipkart(driver);
        PropertyUtilities propertyutilities=new PropertyUtilities();
        loginpageflipkart.getUsernameField().sendKeys(propertyutilities.readingFromPropertyFile("./Data/PinCode.properties","username"));
        loginpageflipkart.getPasswordField().sendKeys(propertyutilities.readingFromPropertyFile("./Data/PinCode.properties","password"));
        loginpageflipkart.getSubmitButton().click();
    }
    @AfterMethod
    public void logout() {
    }
}

