package utils.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
     private  WebDriverWait wait;

     public WaitUtils(WebDriver driver){
         wait=new WebDriverWait(driver, Duration.ofSeconds(10));

     }
     public void waitForVisibility(By locator){
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

     }
     public void waitForPresence(By locator){
         wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     }

    public void waitForClickability(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisibility(By locator) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitForUrlContains(String urlPart) {

        wait.until(ExpectedConditions.urlContains(urlPart));
    }


}
