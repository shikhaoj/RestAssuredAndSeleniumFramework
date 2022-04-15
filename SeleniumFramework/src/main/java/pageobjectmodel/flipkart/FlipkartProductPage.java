package pageobjectmodel.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.PropertyUtilities;
import utils.WebDriverUtility;
import java.io.IOException;
import java.util.List;

/**
 * @author Shikha Rani
 */
public class FlipkartProductPage extends BaseClass {
    /**
     *
     * @param driver
     */
    public FlipkartProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    PropertyUtilities propertyutilities=new PropertyUtilities();
    WebDriverUtility webdriverutility=new WebDriverUtility();
    @FindBy(xpath = "//input[@placeholder='Enter Delivery Pincode']")
    private WebElement pinCode;
    @FindBy(css = "button._2KpZ6l._2U9uOA._3v1-ww")
    private WebElement addToCart;
    @FindBy(css = "button._2KpZ6l")
    private WebElement placeOrder;
    @FindBy(className = "_21Ahn-")
    private List<WebElement> highlights;
    @FindBy(css = "div._1SLzzw")
    private WebElement pinCodeRelatedProductInformation;
    @FindBy(className = "_2P_LDn")
    private WebElement pinCheckOrChange;
    /**
     *
     * @return WebElement
     */
    public WebElement getPinCode() {
        return pinCode;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getAddToCart() {
        return addToCart;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getPlaceOrder() {
        return placeOrder;
    }
    /**
     *
     * @return ListOfWebElements
     */
    public List<WebElement> getHighlights() {
        return highlights;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getPinCodeRelatedProductInformation() {
        return pinCodeRelatedProductInformation;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getPinCheckOrChange() {
        return pinCheckOrChange;
    }
    /**
     *
     * @param path
     * @throws IOException
     */
    public void pinCodeSettingMethod(String path) throws IOException {
        webdriverutility.explicitWait("Visibility", getPinCode());
        getPinCode().sendKeys(propertyutilities.readingFromPropertyFile(path,"pincode"));
        webdriverutility.explicitWait("Clickable", getPinCheckOrChange());
        getPinCheckOrChange().click();
        webdriverutility.explicitWait("Visibility", getPinCodeRelatedProductInformation());
        System.out.println(getPinCodeRelatedProductInformation().getText());
        driver.navigate().refresh();
        webdriverutility.explicitWait("Visibility", getPinCodeRelatedProductInformation());
    }
    public void AddingProductToCart(){
        webdriverutility.explicitWait("Visibility",getAddToCart());
        driver.navigate().refresh();
        getAddToCart().click();
    }
}

