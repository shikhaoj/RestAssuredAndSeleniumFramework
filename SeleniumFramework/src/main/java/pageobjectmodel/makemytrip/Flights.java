package pageobjectmodel.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flights {
    public Flights(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "root")
    private WebElement rootElement;

    @FindBy(id = "fromCity")
    private WebElement source;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromPlaceholder;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toPlaceholder;

    @FindBy(xpath = "//p[contains(text(),'Bhopal, India')]")
    private WebElement visibilityOfSource;

    @FindBy(css = "p.font14.appendBottom5.blackText")
    private WebElement visibilityOfDestination;

    public WebElement getRootElement() {
        return rootElement;
    }

    public WebElement getSource() {
        return source;
    }

    public WebElement getFromPlaceholder() {
        return fromPlaceholder;
    }

    public WebElement getToPlaceholder() {
        return toPlaceholder;
    }

    public WebElement getVisibilityOfSource() {
        return visibilityOfSource;
    }

    public WebElement getVisibilityOfDestination() {
        return visibilityOfDestination;
    }

}
