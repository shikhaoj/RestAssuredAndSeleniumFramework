package pageobjectmodel.nuakridownloadandupload;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
    public Homepage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='UPDATE PROFILE']")
    private WebElement updateProfileButton;

    public WebElement getUpdateProfileButton() {
        return updateProfileButton;
    }


}

