package pageobjectmodel.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Shikha Rani
 */
public class LoginPageFlipkart {
    public LoginPageFlipkart(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[2]")
    private WebElement passwordField;
    @FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[1]")
    private WebElement usernameField;
    @FindBy(css = "button._2KpZ6l._2HKlqd._3AWRsL")
    private WebElement submitButton;
    /**
     *
     * @return WebElement
     */
    public WebElement getPasswordField()
    {
        return passwordField;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getUsernameField()
    {
        return usernameField;
    }
    /**
     *
     * @return WebElement
     */
    public WebElement getSubmitButton(){
        return submitButton;
    }
}

