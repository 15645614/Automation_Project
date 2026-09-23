package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPage {

    WebDriver driver;


    By itemNames =
            By.className("inventory_item_name");

    By itemPrices =
            By.className("inventory_item_price");

    By subtotal =
            By.className("summary_subtotal_label");

    By tax =
            By.className("summary_tax_label");

    By total =
            By.className("summary_total_label");

    By finishButton =
            By.id("finish");


    public OverviewPage(WebDriver driver) {

        this.driver = driver;
    }
    public List<WebElement> getItemNames() {

        return driver.findElements(itemNames);
    }


    public List<WebElement> getItemPrices() {

        return driver.findElements(itemPrices);
    }


    public String getSubtotal() {

        return driver.findElement(subtotal)
                .getText();
    }


    public String getTax() {

        return driver.findElement(tax)
                .getText();
    }


    public String getTotal() {

        return driver.findElement(total)
                .getText();
    }


    public void clickFinish() {

        driver.findElement(finishButton)
                .click();
    }

}