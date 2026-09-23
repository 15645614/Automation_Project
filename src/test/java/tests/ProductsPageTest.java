package tests;
import base.BaseTest;
import page.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProductsPageTest extends BaseTest {
    ProductsPage productsPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setProductsPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productsPage =new ProductsPage(driver);

    }

    @Test
    public void verifyUiElements(){
        String title =productsPage.getPageTitle();
        Assert.assertEquals(title,"Products");
    }


    @Test
    public void verifyProductExist(){
        List<WebElement> products = productsPage.getProducts();
        Assert.assertTrue(products.size()>0);
    }

    @Test
    public void verifyProductsPrices(){
        List<WebElement> prices=productsPage.getProductPrice();
        for (WebElement price:prices){
            Assert.assertTrue(price.isDisplayed());
        }
    }
    @Test
    public void verifyMenu() {

        WebElement burgerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
        burgerBtn.click();

        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        Assert.assertTrue(logoutLink.isDisplayed(), "Menyu içindəki elementlər görünmədi!");
    }
    @Test
    public void verifyCartButton(){
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated( By.className("shopping_cart_link")));

        cartButton.click();

        String cartUrl= driver.getCurrentUrl();
        Assert.assertEquals(cartUrl,"https://www.saucedemo.com/cart.html");
    }
    @Test
    public void verifySortDropdown(){
        boolean isOpened = productsPage.isSortDropdownActive();
        Assert.assertTrue(isOpened,"menu is not aviable");
    }

}



