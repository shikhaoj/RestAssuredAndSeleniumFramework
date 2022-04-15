package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

/**
 * @author Shikha Rani
 */

public class WebDriverUtility extends BaseClass {
   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    private String expectedCondition;
    private WebElement webElement;
    /**
     *
     * @param expectedCondition
     * @param webElement
     */
    public void explicitWait(String expectedCondition, WebElement webElement){
        this.expectedCondition = expectedCondition;
        this.webElement = webElement;
        if(this.expectedCondition == "Clickable"){
           wait.until(ExpectedConditions.elementToBeClickable(this.webElement));
       }
       else{
           wait.until(ExpectedConditions.visibilityOf(this.webElement));
       }
   }
    /**
     *
     * @param timeInSeconds
     */
   public void implicitWait(int timeInSeconds){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
   }
   public void switchWindow(){
       Set<String> s=driver.getWindowHandles();
       String parentWindow= driver.getWindowHandle();
       for (String window:s){
           if (parentWindow!=window){
               driver.switchTo().window(window);
           }
       }
   }
}

