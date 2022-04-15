package pageobjectmodel.amazonpommodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspecificpage {
    public Productspecificpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
