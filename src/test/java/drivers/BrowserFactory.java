package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver createBrowser(String browserName) throws RuntimeException {
        WebDriver driver;
        driver = switch (browserName.trim().toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "safari"-> new SafariDriver();
            default -> throw new RuntimeException("Unsupported Browser: " + browserName);
        };
        driver.manage().window().maximize();
        return driver;
    }
}
