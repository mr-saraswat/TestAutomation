package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.*;

public class InventoryTests extends BaseTest {
    private InventoryPage inventoryPage;
    @BeforeMethod
    public void navigation(){
        LoginPage loginPage = new LoginPage();
        inventoryPage = loginPage.loginAsStandardUser();
    }

    @Test
    public void cartCountAfterAdd()
    {
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.cartCount();
        inventoryPage.removeProductfromCart("Sauce Labs Backpack");
        inventoryPage.cartCount();
    }
    @Test
    public void filterTest()
    {
        List<InventoryPage.ProductDetails> before = inventoryPage.getProductDetails();
        inventoryPage.filterZtoA();
        List<InventoryPage.ProductDetails> after = inventoryPage.getProductDetails();
        List<String> expectedNames = before.stream()
                .map(InventoryPage.ProductDetails::name)
                .sorted()
                .toList();
        List<String> actualNames = after.stream()
                .map(InventoryPage.ProductDetails::name).toList().reversed();
        Assert.assertEquals(actualNames, expectedNames);

        before = inventoryPage.getProductDetails();
        inventoryPage.filterAtoZ();
        after = inventoryPage.getProductDetails();
        expectedNames = before.stream()
                .map(InventoryPage.ProductDetails::name)
                .sorted()
                .toList();
        actualNames = after.stream()
                .map(InventoryPage.ProductDetails::name).toList();
        Assert.assertEquals(actualNames, expectedNames);
        inventoryPage.filterPriceHightoLow();
        after = inventoryPage.getProductDetails();
        List<Double> expectedPrice = before.stream()
                .map(InventoryPage.ProductDetails::price)
                .sorted()
                .toList();
        List<Double> actualPrices = after.stream()
                .map(InventoryPage.ProductDetails::price).toList().reversed();
        Assert.assertEquals(actualPrices, expectedPrice);
        inventoryPage.filterPriceLowtoHigh();
        after = inventoryPage.getProductDetails();
        expectedPrice = before.stream()
                .map(InventoryPage.ProductDetails::price)
                .sorted()
                .toList();
        actualPrices = after.stream()
                .map(InventoryPage.ProductDetails::price).toList();
        Assert.assertEquals(actualPrices, expectedPrice);
    }

    @Test
    public void aboutPage()
    {
    inventoryPage.about();
    Assert.assertEquals(driver.getTitle(),"Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
    }

    @Test
    public void resetPage(){
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.resetPage();
        Assert.assertEquals(inventoryPage.cartCount(),"");
    }
    @Test
    public void displayAllItems(){
        inventoryPage.displayAllItems();
    }

    @Test
    public void navigateToCart(){
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        CartPage cartPage = new CartPage();
        cartPage.getLivePageTitleText();

    }

}
