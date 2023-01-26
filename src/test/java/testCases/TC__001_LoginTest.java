package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC__001_LoginTest extends BaseClass{
    @Test()
    public void login_test(){

        try {
            LoginPage login_obj = new LoginPage(driver);

            //logger.debug("Application Logs");  //logging we can change the type of logs in the log4j2.xml file

            logger.info("*** Landed on the login page ***");  //log message used by the

            login_obj.click_Username(rb.getString("username"));  // This value is feeded from config.prop file
            login_obj.click_Password(rb.getString("password"));

            logger.info("*** Entered the user credentials ***"); //log message

            login_obj.click_login_btn();

            logger.info("*** Clicked the login_button ***");

            //Code for validation

            Thread.sleep(3000);
            WebElement dashboard_word = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
            Assert.assertEquals(dashboard_word.getText(), "Dashboard", "Dashboard not displayed test failed");

            logger.info("*** Test has been passed and validated ***");
        }
        catch(Exception e){
            Assert.fail();
            logger.info("*** Test Failed ***");
        }
    }




}
