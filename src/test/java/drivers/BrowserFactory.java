package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    public static WebDriver createBrowser(String browserName) throws RuntimeException {
        WebDriver driver;
        driver = switch (browserName.trim().toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-notifications");

                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);
                chromePrefs.put("profile.password_manager_leak_detection", false);
                options.setExperimentalOption("prefs", chromePrefs);

                // The missing piece: yielding the initialized driver instance
                yield new ChromeDriver(options);
            }
            case "safari"-> new SafariDriver();
            default -> throw new RuntimeException("Unsupported Browser: " + browserName);
        };
        driver.manage().window().maximize();
        return driver;
    }
}
