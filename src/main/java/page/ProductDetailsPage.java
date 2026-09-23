package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    WebDriver driver;

    By productName =
            By.className("inventory_details_name");

    By productDescription =
            By.className("inventory_details_desc");

    By productPrice =
            By.className("inventory_details_price");


    By addToCartButton =
            By.cssSelector("button[id^='add-to-cart']");

    By backButton =
            By.id("back-to-products");




    //Constructor
    public ProductDetailsPage(WebDriver driver){
        this.driver=driver;
    }


    public String getProductName() {

        return driver.findElement(productName).getText();
    }
    public String getProductDescription(){
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice() {

        return driver.findElement(productPrice)
                .getText();
    }

    public boolean IsEnabledAddToCartBtn(){
        return driver.findElement(addToCartButton).isEnabled();

    }
    public void BackButton(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).click();

    }




}
