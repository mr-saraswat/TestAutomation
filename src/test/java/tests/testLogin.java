package tests;
import base.baseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import config.ConfigReader;
import java.time.Duration;

public class testLogin extends baseTest{
    @Test
    public void login()
    {
        System.out.println("login attempt for User : "+
                ConfigReader.getProperty("username")+" with Password : "+
                ConfigReader.getProperty("password"));
        driver.findElement(By.xpath("//input[@id='user-name']")).
                sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.xpath("//input[@id='password']")).
                sendKeys(ConfigReader.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("logged in");


    }

}
