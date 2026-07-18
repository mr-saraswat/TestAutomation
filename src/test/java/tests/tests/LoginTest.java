package tests;
import base.BaseTest;

import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void login()
    {
        LoginPage loginPage = new LoginPage();

        InventoryPage inventoryPage =loginPage.login();
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        System.out.println(inventoryPage.cartCount());

    }

}
