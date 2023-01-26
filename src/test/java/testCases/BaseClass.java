package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager; //logging
import org.apache.logging.log4j.core.Logger; //logging
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {

    static WebDriver driver;

    public Logger logger;   // Creating a logger variable

    public ResourceBundle rb;   // Here we are creating resourcebundle variable

    @Parameters ({"browser"})

    @BeforeClass
    public void setup(@Optional("Chrome") String br){

        logger= (Logger) LogManager.getLogger(this.getClass());
        rb=ResourceBundle.getBundle("config");  // We are initializing the resourcebundle variable

        if(br.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        }
        else if(br.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        } else if (br.equalsIgnoreCase("FireFox")) {
            driver=new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();  //Command used to delete the cookies in the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //implicit wait for the webelements to load
        driver.get(rb.getString("appURL"));   // This value is feeded from config.prop file
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tear_down(){
        driver.quit();   //Quiting the browser after the test execution
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
}
