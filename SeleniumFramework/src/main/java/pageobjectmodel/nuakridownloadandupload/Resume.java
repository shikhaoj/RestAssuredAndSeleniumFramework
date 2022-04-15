package pageobjectmodel.nuakridownloadandupload;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resume
{
    public Resume(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="attachCV")
    private WebElement uploadResume;

    @FindBy(css = "div.right.download>i.icon")
    private WebElement downloadButton;


    public WebElement getUploadResume() {
        return uploadResume;
    }

    public WebElement getDownloadButton() {
        return downloadButton;
    }
}


