package tests;

import base.BaseTest;
import page.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDetailsPageTest extends BaseTest {

    ProductDetailsPage detailsPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setDetailsPage() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("item_4_title_link"))).click();

        detailsPage = new ProductDetailsPage(driver);
    }

    @Test
    public void addElementBtnTest() {
        Assert.assertTrue(detailsPage.IsEnabledAddToCartBtn());

    }

    @Test
    public void productNameTest() {
        Assert.assertEquals(detailsPage.getProductName(), "Sauce Labs Backpack");

    }
    @Test
    public void productPriceTest(){
        Assert.assertEquals(detailsPage.getProductPrice(),"$29.99");
    }
    @Test
    public void productDescriptionTest() {
        Assert.assertTrue(detailsPage.getProductDescription().length()>0);


    }
    @Test
    public void backBtnTest(){
        detailsPage.BackButton();
        String mainUrl=driver.getCurrentUrl();
        Assert.assertEquals(mainUrl,"https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void verifyRemoveTest(){

        driver.findElement(By.id("add-to-cart")).click();

        Assert.assertTrue(driver.getPageSource().contains("remove"));

    }

}

