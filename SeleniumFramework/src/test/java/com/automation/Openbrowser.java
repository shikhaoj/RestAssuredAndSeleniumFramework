package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Openbrowser {

   // static {
        //System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
   // }
    @Test

    public static void method(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        /**
         * Maximizing the size of the window
         */
        driver.manage().window().maximize();
        //driver.get("https://www.google.com");
        /**
         * We have finded the search bar element and then typed java automatically and navigated to java search result page.
         * given by the findElement as we have the single element with name key
         */
        //WebElement box = driver.findElement(By.name("q"));
        //box.sendKeys("Java");
        //box.sendKeys(Keys.ENTER);
        /**
         * findElements will give list of all the elements with tagNme "a"
         * then printed the number of links
         * And then printed all the links
         */
        //List<WebElement> d = driver.findElements(By.tagName("a"));
        //for (int i = 0; i < d.size(); i++) {

            // Print all elements of List
            //System.out.println(d.get(i).getAttribute("href"));
            //}
        //driver.get("http://omayo.blogspot.com");
        //List<WebElement> s = driver.findElements(By.tagName("input"));
        /**
         * Wanted only button 2 to be clicked
         */
        //WebElement f = driver.findElement(By.xpath("(//button)[2]"));
        //f.click();

        //List<WebElement> inp = driver.findElements(By.tagName("input"));
        //System.out.println(s.size());

        //System.setProperty("WebDriver.chrome.driver","/home/raramuri/IdeaProjects/selenium/src/driver/chromedriver");
        //List<WebElement> alllinks = driver.findElements(By.tagName("a"));
        //for (int i = 0; i < inp.size(); i++) {

            // Print all elements of List
            //System.out.println(inp.get(i).getAttribute("name"));
            //}
        //driver.findElement(By.linkText("Selenium143")).click();
        /**
         * Used id as we can have different different types of link with same text in the side but id
         * is unique for every link
         */
        //driver.findElement(By.id("link2")).click();
        /**
         * Suppose example of no. of emails in link text it can from be 5 mails to 50 mails and so
         * on so there linkText will not work but partialLinkText will work link text "mail 5" can
         * change to "mail  100" suppose but the term mail will remain as such constant
         */
        //driver.findElement(By.partialLinkText("wisely")).click();
        //driver.findElement(By.cssSelector("a[href]=\"http://omayo.blogspot.com/2013/05/page-one.html\""));
        driver.get("https://www.amazon.in/");
        //String window= driver.getTitle();
        //System.out.println(window);
        String mainWin = driver.getWindowHandle();
        System.out.println(mainWin);

        //switch to child window

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        /**
         * x-path
         */
        //driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("apple iphone 13");
        //driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input")).click();
        /**
         * through id
         */

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple iphone 13");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.findElement(By.partialLinkText("Apple iPhone 13 Mini (128GB) - Starlight")).click();
        //String parent= driver.getWindowHandle();

        Set<String>s=driver.getWindowHandles();
        System.out.println(s);
        Iterator<String> I1=s.iterator();
        String child_window=I1.next();
        System.out.println(child_window);
        //if(window==)
        //driver.switchTo().window(child_window).getTitle();

        //driver.switchTo().window(child_window);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("add-to-cart-button")).click();

    }
}
