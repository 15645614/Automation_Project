package tests;

import base.BaseTest;
import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.OverviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OverviewPageTest extends BaseTest {
    OverviewPage overviewPage;
    WebDriverWait wait;
    @BeforeMethod
    public void setOverviewPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartBtn();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        cartPage.clickCheckout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInformation("Elshan", "Mammadov", "1000");
        checkoutPage.clickContinue();

        overviewPage = new OverviewPage(driver);

    }
    @Test
    public void verifyProductOnOverview() {

        Assert.assertEquals(
                overviewPage.getItemNames().get(0).getText(),"Sauce Labs Backpack");
    }
    @Test
    public void verifySubtotal() {

        Assert.assertTrue(
                overviewPage.getSubtotal()
                        .contains("29.99")
        );
    }


    @Test
    public void verifyTaxDisplayed() {

        Assert.assertTrue(
                overviewPage.getTax().contains("2.40"));
    }



}
