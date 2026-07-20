package tests;
import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test(priority = 1)
    public void login()
    {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();
        Assert.assertEquals(inventoryPage.getLivePageTitleText(),"Swag Labs");
    }
    @Test(priority = 2)
    public void logout()
    {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();
        Assert.assertEquals(inventoryPage.getLivePageTitleText(),"Swag Labs");
        inventoryPage.logout();
        Assert.assertEquals(loginPage.getLivePageTitleText(),"Swag Labs");
    }

}
