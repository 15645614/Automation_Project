package tests;

import base.BaseTest;
import page.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartPageTest extends BaseTest {
    CartPage cartPage;
    WebDriverWait wait;
    @BeforeMethod
    public void setCartPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bike-light"))).click();
        cartPage=new CartPage(driver);

    }
    @Test
    public void verifycartButton(){
        Assert.assertTrue(cartPage.isDisplayedCartButton());
        Assert.assertTrue(cartPage.isEnabledCartButton());
    }
    @Test
    public void verifycartLink(){
        cartPage.clickCartBtn();
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/cart.html");
    }
    @Test
    public void cartIndicatorTest(){
        Assert.assertTrue(cartPage.IsDisplayedcartIndicator());
    }
    @Test
    public void checkoutBtnTest(){
        cartPage.clickCartBtn();
        Assert.assertTrue(cartPage.IsDisplayedCheckoutBtn());
        Assert.assertTrue(cartPage.IsEnabledCheckoutBtn());
    }
    @Test
    public void continueShopBtnTest(){
        cartPage.clickCartBtn();
        Assert.assertTrue(cartPage.IsDisplayedContinueShopBtn());
        Assert.assertTrue(cartPage.IsEnabledContinueShopBtn());
    }

    @Test
    public void verifyProductsPrice(){
        cartPage.clickCartBtn();
        Assert.assertEquals(
                cartPage.getPrices().get(0).getText(), "$29.99");

        Assert.assertEquals(
                cartPage.getPrices().get(1).getText(), "$9.99");
    }

    @Test
    public void verifyQuantity(){

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"2");

    }
    @Test
    public void verifyTitle(){
        Assert.assertTrue(cartPage.IsDisplayedTitle());
    }


}
