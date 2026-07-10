package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
    private static WebDriver driver;

    private driverFactory(){

    }
    public static WebDriver initDriver()
    {
        String browser = ConfigReader.getProperty("browser");

        if(browser == null || browser.trim().isEmpty())
        {
            throw new RuntimeException("Warning : Please add browser name in config file " +
                    "please switch to chrome or any other browser..");
        }
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Unsupported Browser");
        }
        driver.manage().window().maximize();

        return  driver;

    }
    public static WebDriver getDriver()
    {
        if(driver == null)
            return initDriver();
        else
            return driver;
    }
    public static void quitDriver(){
        if(driver!= null)
        {
            driver.quit();
            driver=null;
        }
    }

}
