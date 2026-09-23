package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver(ConfigReader.getProperty("browser"));

        driver.get(ConfigReader.getProperty("url"));

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    public WebDriver getDriver() {
        return driver;
    }
}
