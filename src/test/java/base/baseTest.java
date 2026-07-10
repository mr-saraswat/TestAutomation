package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import  drivers.driverFactory;

public class baseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver =driverFactory.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getProperty("implicitlyWait")));
        driver.get(ConfigReader.getProperty("url"));
    }


    public void closeBrowser(){
        driver.quit();
    }
}
