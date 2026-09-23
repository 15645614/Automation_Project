package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeScreenshot(
            WebDriver driver,
            String fileName) {

        File directory =
                new File("screenshots");

        if (!directory.exists()) {
            directory.mkdirs();
        }

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File source =
                screenshot.getScreenshotAs(
                        OutputType.FILE
                );

        File destination =
                new File(
                        directory,
                        fileName + ".png"
                );

        try {

            FileUtils.copyFile(
                    source,
                    destination
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}