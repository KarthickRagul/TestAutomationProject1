package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;  //Object of WebDriver class

    public BasePage(WebDriver driver){   // Constructor of the BasePage
        this.driver=driver;
        PageFactory.initElements(driver, this);  // POM - Here we are initializing the elements in a single statements
    }
}
