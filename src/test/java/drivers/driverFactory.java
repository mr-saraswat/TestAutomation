package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverFactory {
    private static WebDriver driver;
    private driverFactory(){

    }
    public static WebDriver initDriver()
    {
        if(driver == null) {
            driver = new ChromeDriver();
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
