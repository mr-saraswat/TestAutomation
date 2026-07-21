package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage
{
    protected By headerTitleLocator= By.className("app_logo");
    protected By pageOptions= By.id("react-burger-menu-btn");
    protected By logoutBtn= By.xpath("//a[text()='Logout']");
    protected By aboutBtn= By.xpath("//a[text()='About']");
    protected By resetPageBtn= By.xpath("//a[text()='Reset App State']");
    protected By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    protected By cartItemContainer = By.className("inventory_item");
    protected By cartItemQty = By.className("cart_quantity");
    protected By cartItemName = By.className("inventory_item_name");
    protected By cartItemDesc = By.className("inventory_item_desc");
    protected By cartItemPrice = By.className("inventory_item_price");


    public Integer cartCount(){
        return Integer.parseInt(getElement(shoppingCartBadge).getText());
    }

    public void returnToInventory()
    {
    click(By.id("continue-shopping"));
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


    public record ProductDetails(Integer quantity , String name, String desc, Double price){}

    public List<ProductDetails> getProductDetails(){
        List<WebElement> cartItems = getElements(cartItemContainer);

        return  cartItems.stream().map(card->
                new CartPage.ProductDetails(Integer.parseInt(card.findElement(cartItemQty).getText().trim()),
                        card.findElement(cartItemName).getText().trim(),
                        card.findElement(cartItemDesc).getText().trim(),
                        Double.parseDouble(card.findElement(cartItemPrice).getText().
                                replace("$","").trim()))).toList();
    }



}
