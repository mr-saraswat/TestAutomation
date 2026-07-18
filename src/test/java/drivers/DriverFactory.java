package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    private DriverFactory(){
        // Private constructor to prevent instantiation
    }

    public static WebDriver initDriver()
    {
        String browser = ConfigReader.getProperty("browser");

        if(browser == null || browser.trim().isEmpty())
        {
            throw new RuntimeException("Warning : Please add browser name in config file. " +
                    "Please switch to chrome or any other browser.");
        }

        WebDriver newDriver = BrowserFactory.createBrowser(browser);
        driver.set(newDriver);
        return newDriver;
    }

    public static WebDriver getDriver()
    {
        if(driver.get() == null) {
            return initDriver();
        }
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null)
        {
            driver.get().quit();
            driver.remove(); // Remove the driver from ThreadLocal
        }
    }
}