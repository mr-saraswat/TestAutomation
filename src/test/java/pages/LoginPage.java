package pages;

import config.ConfigReader;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    protected final By username = By.id("user-name");
    protected final By password = By.id("password");
    protected final By submit = By.id("login-button");
    protected final By errormessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(){
        super();
    }

    public InventoryPage login()
    {
        sendKeys(username,ConfigReader.getProperty("username"));
        sendKeys(password,ConfigReader.getProperty("password"));
        click(submit);
        return new InventoryPage();
    }

    public String getErrorMessage(){
        return getText(errormessage);
    }
}
