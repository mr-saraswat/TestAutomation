package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.ConfigReader;

import java.time.Duration;


public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Duration TIMEOUT_DURATION = Duration.ofSeconds((long)
            Long.parseLong(ConfigReader.getProperty("TIMEOUT_DURATION")));


    protected BasePage() { // Modified constructor
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(this.driver, TIMEOUT_DURATION);
    }

    protected WebElement getElement(By locator){
        // Corrected usage of ExpectedConditions
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator){
        // Corrected usage of ExpectedConditions
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Optional: Add a method to get text
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}