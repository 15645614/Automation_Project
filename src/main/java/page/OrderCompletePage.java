package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletePage {

    WebDriver driver;


    By completeMessage =
            By.className("complete-header");

    By backHomeButton =
            By.id("back-to-products");


    public OrderCompletePage(WebDriver driver) {

        this.driver = driver;
    }


    public String getCompleteMessage() {

        return driver.findElement(completeMessage)
                .getText();
    }


    public boolean isCompleteMessageDisplayed() {

        return driver.findElement(completeMessage)
                .isDisplayed();
    }


    public void backHome() {

        driver.findElement(backHomeButton)
                .click();
    }
}