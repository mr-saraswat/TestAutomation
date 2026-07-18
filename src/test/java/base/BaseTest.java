package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import drivers.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.
                parseInt(ConfigReader.getProperty("TIMEOUT_DURATION"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.
                parseInt(ConfigReader.getProperty("pageLoadTimeout"))));
        driver.get(ConfigReader.getProperty("url"));
    }

@AfterMethod
public void closeBrowser() throws InterruptedException {
       Thread.sleep(10000);
    DriverFactory.quitDriver();
    }
}
