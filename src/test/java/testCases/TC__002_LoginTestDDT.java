package testCases;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC__002_LoginTestDDT extends BaseClass{

    @Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class)
    public void loginTesDDT(String username, String pwd, String status) throws InterruptedException {

        try {
            logger.info("*** Started the test***");

            LoginPage login_obj = new LoginPage(driver);

            login_obj.click_Username(username);  // This value is feeded from excel file
            login_obj.click_Password(pwd);

            logger.info("*** Entered the user credentials ***"); //log message

            login_obj.click_login_btn();

            logger.info("*** Clicked the login_button ***");

            Thread.sleep(3000);
            String dashboard_url = driver.getCurrentUrl();
            boolean target_page_displayed= false;
            if (dashboard_url.contains("dashboard")) {
                target_page_displayed = true;
            }
            if (status.equals("Valid")) {
                if (target_page_displayed) {
                    login_obj.click_myprofile();
                    login_obj.click_logout_btn();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }

            }

            if (status.equals("Invalid")) {
                if (target_page_displayed) {
                    login_obj.click_myprofile();
                    login_obj.click_logout_btn();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }

            }
        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("Test executed successfully");
    }
}
