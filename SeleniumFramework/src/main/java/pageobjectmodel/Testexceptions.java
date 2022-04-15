package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testexceptions{
   public Testexceptions(WebDriver driver){
       PageFactory.initElements(driver,this);
   }

   @FindBy(css = "p#instructions")
   private WebElement instruction;

   @FindBy(css="button#add_btn")
   private WebElement addButton;

    public WebElement getInstruction() {
        return instruction;
    }

    public WebElement getAddButton() {
        return addButton;
    }
}
