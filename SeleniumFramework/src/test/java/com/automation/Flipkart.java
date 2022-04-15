package com.automation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectmodel.flipkart.FlipkartHomePage;
import pageobjectmodel.flipkart.FlipkartListOfProducts;
import pageobjectmodel.flipkart.FlipkartProductPage;
import utils.BaseClass;
import utils.ExcelUtilities;
import utils.PropertyUtilities;
import utils.WebDriverUtility;
import java.awt.*;
import java.io.IOException;

/**
 * @author Shikha Rani
 */

@Listeners(utils.ListenerTest.class)
public class Flipkart extends BaseClass {
    /**
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws AWTException
     */
    @Test
    public void ordering() throws InterruptedException, IOException, AWTException {
        driver.navigate().refresh();
        WebDriverUtility webdriverutility=new WebDriverUtility();
        webdriverutility.implicitWait(20);
        FlipkartHomePage flipkarthomepage=new FlipkartHomePage(driver);
        FlipkartProductPage flipkartproductpage=new FlipkartProductPage(driver);
        FlipkartListOfProducts flipkartlistofproducts=new FlipkartListOfProducts(driver);
        ExcelUtilities excelutilities=new ExcelUtilities();
        PropertyUtilities propertyutilities=new PropertyUtilities();
        Assert.assertEquals(driver.getTitle(),propertyutilities.readingFromPropertyFile("./Data/PinCode.properties","mainpagetitle"));
        flipkarthomepage.mouseHoverToCategory();
        webdriverutility.explicitWait("Visibility",flipkarthomepage.getBluetoothSpeakers());
        flipkarthomepage.getBluetoothSpeakers().click();
        flipkartlistofproducts.lowestPriceProductMethodByUser();
        webdriverutility.switchWindow();
        Assert.assertEquals(driver.getTitle(),propertyutilities.readingFromPropertyFile("./Data/PinCode.properties","childpagetitle"));
        driver.navigate().refresh();
        excelutilities.write("./Data/WritingInExcel.xlsx",0,0,0);
        driver.navigate().refresh();
        flipkartproductpage.pinCodeSettingMethod("./Data/PinCode.properties");
        flipkartproductpage.AddingProductToCart();
        driver.navigate().refresh();
        webdriverutility.explicitWait("Clickable",flipkartproductpage.getPlaceOrder());
        }
    }

