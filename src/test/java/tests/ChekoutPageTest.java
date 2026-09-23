package tests;

import base.BaseTest;
import page.CheckoutPage;
import page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChekoutPageTest extends BaseTest {

    CheckoutPage checkoutPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setCheckoutPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();

        WebElement cartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_link")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);

        wait.until(ExpectedConditions.urlContains("cart.html"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        checkoutPage = new CheckoutPage(driver);

    }

    @DataProvider(name = "checkinformation")
    public Object[][] getCheckData() {
        return new Object[] []{
// { First Name, Last Name, Zip Code, Gözlənilən Xəta Mesajı }
                { "", "Doe", "1000", "Error: First Name is required" },
                { "John", "", "1000", "Error: Last Name is required" },
                { "John", "Doe", "", "Error: Postal Code is required" }
        };

    }
    @Test(dataProvider = "checkinformation")
    public void verifyCheckoutValidation(String name,String lname,String code,String errorMessage){

        checkoutPage.enterFirstName(name);
        checkoutPage.enterLastName(lname);
        checkoutPage.enterZipCode(code);

        // Continue düyməsinə klikləyirik
        checkoutPage.clickContinue();

        // Ekranda çıxan xəta mesajını götürüb yoxlayırıq
        String actualErrorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, errorMessage, "Xəta mesajı uyğun gəlmədi!");
    }
    @Test
    public void cancelBtnTest(){
        checkoutPage.clickCancelBtn();
        String cartUrl=driver.getCurrentUrl();
        Assert.assertEquals(cartUrl,"https://www.saucedemo.com/cart.html");
    }

}




