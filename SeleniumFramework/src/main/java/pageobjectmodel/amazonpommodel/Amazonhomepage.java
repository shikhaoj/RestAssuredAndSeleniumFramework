package pageobjectmodel.amazonpommodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonhomepage {

    public Amazonhomepage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitButton;

    @FindBy(partialLinkText = "Apple iPhone 13 (512GB) - Starlight")
    private WebElement productTypeOne;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getProductTypeOne() {
        return productTypeOne;
    }
}
