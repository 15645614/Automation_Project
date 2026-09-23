package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.OrderCompletePage;

import java.time.Duration;

public class OrderCompletePageTest extends BaseTest {
    WebDriverWait wait;
    OrderCompletePage orderCompletePage;

    @BeforeMethod
    public void setOverviewPage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"))).click();
        Thread.sleep(2000);
        CartPage cartPage=new CartPage(driver);
        cartPage.clickCartBtn();
        Thread.sleep(2000);

        cartPage.clickCheckout();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInformation("Elshan", "Mammadov", "1000");
        checkoutPage.clickContinue();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

        orderCompletePage = new OrderCompletePage(driver);

    }


    @Test
    public void verifySuccessText() {

        Assert.assertEquals(
                orderCompletePage.getCompleteMessage(),
                "Thank you for your order!");
    }
}
