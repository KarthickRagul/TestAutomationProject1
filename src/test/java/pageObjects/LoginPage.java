package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{  // Here we are extending the parent class

    public LoginPage(WebDriver driver){  // creating the constructor for initialize the driver object
        super(driver);
    }

    //Web Elements

    @FindBy(xpath="//input[@placeholder='Username']")// With the help of PageFactory we can use the @FindBy method
    WebElement username_box;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement password_box;

    @FindBy(xpath="//button[@type='submit']")
    WebElement login_btn;

    //Get the WebElement for validation
    @FindBy(xpath="//h6[normalize-space()='Dashboard']")
    WebElement dashboard_word;

    //My Profile
    @FindBy(xpath="//body//div//div//div//header//div//div//ul//li//span")
    WebElement my_profile;

    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logout_btn;

    //Auction Methods
    public void click_Username(String user_name){
        username_box.clear();
        username_box.sendKeys(user_name);
    }

    public void click_Password(String password){
        password_box.clear();
        password_box.sendKeys(password);
    }

    public void click_login_btn(){
        login_btn.click();
    }

    public void click_myprofile(){
        my_profile.click();
    }

    public void click_logout_btn(){
        logout_btn.click();
    }

}
