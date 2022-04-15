package pageobjectmodel.nuakridownloadandupload;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
    public Loginpage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()=\"Login\"]")
    private WebElement mainLoginButton;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    private WebElement userpassword;

    public WebElement getLoginButton()
    {
        return loginButton;
    }

    public WebElement getEmail()
    {
        return email;
    }

    public WebElement getUserpassword()
    {
        return userpassword;
    }

    public WebElement getMainLoginButton() {

        return mainLoginButton;
    }
}
