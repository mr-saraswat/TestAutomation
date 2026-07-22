package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;

public class CartPageTests extends BaseTest {
    private CartPage cartPage;
    @BeforeMethod
    public void navigation(){
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        cartPage = inventoryPage.navigateToCart();
        System.out.println(cartPage.getLivePageTitleText());
        System.out.println(cartPage.getPageTitle());
        }

    @Test
    public void testCartItems(){
    List<CartPage.ProductDetails> productDetailsList = cartPage.getProductDetails();
        List<String> productNames = productDetailsList.stream()
                .map(CartPage.ProductDetails::name).toList();
        Assert.assertTrue(productNames.contains("Sauce Labs Backpack"));
        Assert.assertTrue(productNames.contains("Sauce Labs Bike Light"));
        Assert.assertEquals(productDetailsList.toArray().length, 2);
    }

    @Test
    public void navigateToInventory()
    {
        InventoryPage inventoryPage=cartPage.returnToInventory();
        List<InventoryPage.ProductDetails>itemsAddedToCart = inventoryPage.itemsAddedToCart();
        List<String> expectedNames = itemsAddedToCart.stream()
                .map(InventoryPage.ProductDetails::name)
                .sorted()
                .toList();
        Assert.assertTrue(expectedNames.contains("Sauce Labs Backpack"));
        Assert.assertTrue(expectedNames.contains("Sauce Labs Bike Light"));
    }

}
