package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstName =
            By.id("first-name");
    By lastName =
            By.id("last-name");
    By zipCode=
            By.id("postal-code");
    By continueButton =
            By.id("continue");

    By cancelButton =
            By.id("cancel");

    By errorMessage =
            By.cssSelector("[data-test='error']");
    By checkoutBtn= By.id("checkout");

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();

    }


    public void enterFirstName(String name) {

        driver.findElement(firstName)
                .sendKeys(name);
    }


    public void enterLastName(String lname) {

        driver.findElement(lastName)
                .sendKeys(lname);
    }


    public void enterZipCode(String code) {

        driver.findElement(zipCode)
                .sendKeys(code);
    }


    public void clickContinue() {

        driver.findElement(continueButton)
                .click();
    }


    public void fillInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);

        enterLastName(lastName);

        enterZipCode(postalCode);
    }


    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }
    public void clickCancelBtn(){
        driver.findElement(cancelButton).click();
    }


}
