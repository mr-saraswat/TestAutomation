package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{
    protected By headerTitleLocator = By.xpath("//div[@class='login_logo']");
    protected final By username = By.id("user-name");
    protected final By password = By.id("password");
    protected final By submit = By.id("login-button");
    protected final By errormessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(){
        super();
    }

    // Original login method (assuming standard user if no specific method is called)
    public InventoryPage login()
    {
        sendKeys(username,ConfigReader.getProperty("username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    // Login as a standard user (explicitly)
    public InventoryPage loginAsStandardUser()
    {
        sendKeys(username,ConfigReader.getProperty("username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    // Login as a locked out user
    public String loginAsLockedOutUser() // Returns LoginPage as login is expected to fail
    {
        sendKeys(username,ConfigReader.getProperty("locked_username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return getErrorMessage(); // Stay on LoginPage if login fails
    }

    // Login as a problem user
    public InventoryPage loginAsProblemUser()
    {
        sendKeys(username,ConfigReader.getProperty("problem_username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    // Login as a performance glitch user
    public InventoryPage loginAsPerformanceGlitchUser()
    {
        sendKeys(username,ConfigReader.getProperty("performance_glitch_username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    // Login as an error user
    public InventoryPage loginAsErrorUser()
    {
        sendKeys(username,ConfigReader.getProperty("error_username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    // Login as a visual user
    public InventoryPage loginAsVisualUser()
    {
        sendKeys(username,ConfigReader.getProperty("visual_username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    public String getErrorMessage(){
        return getText(errormessage);
    }

    public String getLivePageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleLocator))
                .getText()
                .trim();
    }
}