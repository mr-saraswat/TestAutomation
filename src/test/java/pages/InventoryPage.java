package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{
    protected WebDriver driver = DriverFactory.getDriver();
    protected By headerTitle = By.xpath("//div[@class='app_logo']");
    protected By shoopingCartContainer = By.xpath("//div[@class='shopping_cart_container']");
    protected By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    protected String addToCartbtn = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";


    public InventoryPage() {
        super();
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




}
