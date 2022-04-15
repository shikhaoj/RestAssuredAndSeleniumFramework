package pageobjectmodel.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.WebDriverUtility;
import java.util.List;

/**
 * @author Shikha Rani
 */

public class FlipkartListOfProducts extends BaseClass {
    public FlipkartListOfProducts(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    WebDriverUtility webdriverutility=new WebDriverUtility();
    @FindBy(xpath = "//div[@class=\"_10UF8M\"]")
    private WebElement sortPriceLowToHigh;
    @FindBy(className = "_4ddWXP")
    private List<WebElement> lowestPriceProduct;
    /**
     *
     * @return WebElement
     */
    public WebElement getSortPriceLowToHigh() {
        return sortPriceLowToHigh;
    }
    /**
     *
     * @return ListOfWebElements
     */
    public List<WebElement> getLowestPriceProduct() {
        return lowestPriceProduct;
    }
    public void lowestPriceProductMethodByUser(){
        webdriverutility.explicitWait("Visibility",getSortPriceLowToHigh());
        getSortPriceLowToHigh().click();
        driver.navigate().refresh();
        for(int i=0;i<getLowestPriceProduct().size();i++) {
            System.out.println(getLowestPriceProduct().get(i).getText());
            if (getLowestPriceProduct().get(i).getText().contains("Coming Soon")) {
                continue;
            } else {
                getLowestPriceProduct().get(i).click();
                break;
            }
        }
    }
}

