package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    By pageTitle = By.className("title");

    By productNames =
            By.className("inventory_item_name");

    By productPrices =
            By.className("inventory_item_price");

    By productItems =
            By.className("inventory_item");

    By sortDropdown =
            By.cssSelector("[data-test='product-sort-container']");

    By cartLink =
            By.className("shopping_cart_link");

    By menuButton =
            By.className("bm-burger-button");

    By logoutButton =
            By.linkText("Logout");


    public ProductsPage(WebDriver driver){

        this.driver=driver;
    }


    public void logoutButton(){
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();

    }
    public String getPageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();    }

    public List<WebElement> getProductsName(){
        return driver.findElements(productNames);
    }
    public List<WebElement> getProductPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems));
    }
    public List<WebElement> getProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems));
    }
    public void clickCart(){
        driver.findElement(cartLink).click();
    }
    public void openMenu(){
        driver.findElement(menuButton).click();
    }
    public boolean isSortDropdownActive() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        dropdown.click();

        return dropdown.equals(driver.switchTo().activeElement());
    }


}

