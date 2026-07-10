package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
    private static WebDriver driver;
    private static String browser;
    private driverFactory(){

    }
    public static WebDriver initDriver()
    {
        browser = ConfigReader.getProperty("browser");
        if(browser =="chrome" || browser == null);
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        if(browser =="safari");
        {
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        return  driver;
    }
    public static WebDriver getDriver()
    {
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
