package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.Collectors;

import java.util.List;

public class InventoryPage extends BasePage{
    protected By headerTitleLocator = By.xpath("//div[@class='app_logo']");
    protected By inventoryItemContainer = By.className("inventory_item");
    protected By inventoryItemName = By.className("inventory_item_name");
    protected By inventoryItemDesc = By.className("inventory_item_desc");
    protected By inventoryItemPrice = By.className("inventory_item_price");
    protected By pageOptions= By.id("react-burger-menu-btn");
    protected By logoutBtn= By.xpath("//a[text()='Logout']");
    protected By aboutBtn= By.xpath("//a[text()='About']");
    protected By resetPageBtn= By.xpath("//a[text()='Reset App State']");
    protected By displayAllItemsBtn= By.xpath("//a[text()='All Items']");
    protected By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    protected String addToCartbtn = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";
    protected String removeFromCartbtn = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";


    public InventoryPage() {
        super();
    }

    public String getLivePageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleLocator))
                .getText()
                .trim();
    }

    public void logout(){
        click(pageOptions);
        click(logoutBtn);
    }
    public void about(){
        click(pageOptions);
        click(aboutBtn);
    }
    public void resetPage(){
        click(pageOptions);
        click(resetPageBtn);
    }
    public void displayAllItems(){
        click(pageOptions);
        click(displayAllItemsBtn);
    }
    public void removeProductfromCart(String productName)
    {
        String productXpath = String.format(removeFromCartbtn,productName);
        By addProduct = By.xpath(productXpath);
        click(addProduct);
    }


    public void addProductToCart(String productName)
    {
     String productXpath = String.format(addToCartbtn,productName);
     By addProduct = By.xpath(productXpath);
     click(addProduct);
     }
     public Integer cartCount(){
        return Integer.parseInt(getElement(shoppingCartBadge).getText());
     }


    public record ProductDetails(String name, String desc, String price){}

    public List<ProductDetails> getProductDetails(){
        List<WebElement> inventoryItems = getElements(inventoryItemContainer);

        return  inventoryItems.stream().map(card->
                new ProductDetails(card.findElement(inventoryItemName).getText().trim(),
                card.findElement(inventoryItemDesc).getText().trim(),
                card.findElement(inventoryItemPrice).getText().trim())).toList();
    }


}
