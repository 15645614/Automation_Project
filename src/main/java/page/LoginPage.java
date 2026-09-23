package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.waits.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils waitUtils;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By loginTitle = By.linkText("Swag Labs");
    By errorMessage= By.cssSelector("h3[data-test='error']");

//Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils=new WaitUtils(driver);
    }

//LOGIN
    public void login(String username, String password) {

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }

 //UI VALIDATION
    public boolean IsDisplayedUserName(){
        waitUtils.waitForVisibility(usernameField);
        return driver.findElement(usernameField).isDisplayed();
    }
    public boolean IsDisplayedPassword(){
        waitUtils.waitForVisibility(passwordField);
        return driver.findElement(passwordField).isDisplayed();

    }
    public boolean IsEnabledUsername(){
        waitUtils.waitForVisibility(usernameField);
        return driver.findElement(usernameField).isEnabled();
    }
    public boolean IsEnabledPassword(){
        return driver.findElement(passwordField).isEnabled();
    }
    public boolean IsDisplayedLoginButton(){
        return driver.findElement(loginButton).isDisplayed();
    }
    public boolean IsEnabledLoginButton(){
        waitUtils.waitForVisibility(loginButton);
        return driver.findElement(loginButton).isEnabled();
    }
    public boolean IsDisplayedTitle(){
        return driver.findElement(loginTitle).isDisplayed();
    }

    //Error Message
    public String getErrorMessage(){
        waitUtils.waitForVisibility(errorMessage);
        return driver.findElement(errorMessage).getText();
    }



}