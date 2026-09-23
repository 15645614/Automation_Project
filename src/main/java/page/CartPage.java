package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    By cartButton = By.className("shopping_cart_link");
    By cartIndicator = By.className("shopping_cart_badge");
    By continueShoppingBtn= By.id("continue-shopping");
    By checkoutBtn= By.id("checkout");
    By cartItems =By.className("cart_item");
    By cartItemNames = By.className("inventory_item_name");
    By cartItemPrices = By.className("inventory_item_price");
    By cartPageTitle = By.className("title");

    By cartItemQuantities =
            By.className("cart_quantity");
//Constructor

    public CartPage(WebDriver driver) {
        this.driver=driver;

    }

    public void clickCartBtn(){
        driver.findElement(cartButton).click();
    }
    public boolean isDisplayedCartButton(){
        return driver.findElement(cartButton).isDisplayed();
    }
    public boolean isEnabledCartButton(){
        return driver.findElement(cartButton).isEnabled();
    }
    public boolean IsDisplayedContinueShopBtn(){
        return driver.findElement(continueShoppingBtn).isDisplayed();
    }
    public boolean IsEnabledContinueShopBtn(){
        return driver.findElement(continueShoppingBtn).isEnabled();
    }
    public boolean IsDisplayedcartIndicator(){
        return driver.findElement(cartIndicator).isDisplayed();
    }

    public List<WebElement> getPrices(){
        return driver.findElements(cartItemPrices);
    }

    public boolean IsDisplayedCheckoutBtn(){
        return driver.findElement(checkoutBtn).isDisplayed();
    }
    public boolean IsEnabledCheckoutBtn(){
        return driver.findElement(checkoutBtn).isEnabled();
    }
    //
    public List<WebElement> getCartItems() {
        return  driver.findElements(cartItems);
    }
    public List<WebElement> getCartItemsName(){
        return  driver.findElements(cartItemNames);
    }

    public boolean IsDisplayedTitle(){
        return driver.findElement(cartPageTitle).isDisplayed();
    }
    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();
    }


}
