package pageobjectmodel.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.WebDriverUtility;

/**
 * @author Shikha Rani
 */
public class FlipkartHomePage extends BaseClass {
    /**
     *
     * @param driver
     */
    public FlipkartHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    WebDriverUtility webdriverutility=new WebDriverUtility();
    @FindBy(partialLinkText = "Flipkart")
    private WebElement logo;
    @FindBy(css = "img[alt=\"Electronics\"]")
    private WebElement electronics;
    @FindBy(linkText = "Bluetooth Speakers")
    private WebElement bluetoothSpeakers;
    /**
     *
     * @return WebElement
     */
    public WebElement getLogo() {
        return logo;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getElectronics() {
        return electronics;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getBluetoothSpeakers() {
        return bluetoothSpeakers;
    }
    public void mouseHoverToCategory() {
        Actions actions=new Actions(driver);
        webdriverutility.explicitWait("Clickable",getElectronics());
        actions.moveToElement(getElectronics()).perform();
    }
}

