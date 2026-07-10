package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import  drivers.driverFactory;

public class baseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver =driverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.
                parseInt(ConfigReader.getProperty("implicitWait"))));
        driver.get(ConfigReader.getProperty("url"));
    }

@AfterMethod
public void closeBrowser(){

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.
            parseInt(ConfigReader.getProperty("implicitWait"))));

    driverFactory.quitDriver();
    }
}
