package listener;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.latest.layertree.model.StickyPositionConstraint;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){

        BaseTest test=(BaseTest) result.getInstance();
        WebDriver driver=test.getDriver();

        String methodName=result.getMethod()
                .getMethodName();

        String className=result
                .getTestClass()
                .getRealClass()
                .getSimpleName();

        String timeStamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        String fileName=className+"_"+methodName+"_"+timeStamp;

        ScreenshotUtil.takeScreenshot(driver,fileName);

    }
}
