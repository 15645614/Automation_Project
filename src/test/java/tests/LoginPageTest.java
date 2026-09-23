package tests;

import base.BaseTest;
import dataproviders.LoginDataProvider;
import listener.Listener;
import org.testng.annotations.Listeners;
import page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setLoginPage(){
        loginPage=new LoginPage(driver);
    }

    @Test
    public void LoginUiTest(){

        Assert.assertTrue(loginPage.IsDisplayedUserName());
        Assert.assertTrue(loginPage.IsEnabledUsername());

        Assert.assertTrue(loginPage.IsDisplayedPassword());
        Assert.assertTrue(loginPage.IsEnabledPassword());

        Assert.assertTrue(loginPage.IsDisplayedLoginButton());

        Assert.assertTrue(loginPage.IsEnabledLoginButton());

    }

    @Test
    public void validLoginTest(){
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")   );

                String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/");


    }


    @Test(dataProvider = "loginNegativeData", dataProviderClass = LoginDataProvider.class)
    public void testNegativeLoginScenarios(String username, String password, String expectedErrorMessage) {

        loginPage.login(username, password);

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Xəta mesajı gözlənilənlə üst-üstə düşmədi!");
    }


}
