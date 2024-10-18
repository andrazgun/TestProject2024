package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Set;
import java.util.regex.Pattern;

public class SeleniumUtils {

    //    method for explicit wait
    public static WebElement waitForGenericElement(WebDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
//method for wait for some text to be displayed on webpage and return true if so
    public static Boolean waitforTextOnSite(WebDriver driver, By locator, Duration timeout, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Pattern patt = Pattern.compile(expectedText);
        return wait.until(ExpectedConditions.textMatches(locator, patt));
    }

    //    generic method to find a cookie by name
    public static Boolean checkIfCookieExistsByName(WebDriver driver, String cookieName) {
        Set<Cookie> cookies = driver.manage().getCookies();
        Boolean found = false;
        for (Cookie c:cookies) {
            if (c.getName().equalsIgnoreCase(cookieName)) {
                return true;
            }
        }
        return false;
    }

    public static String takeScreenshot(WebDriver driver) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename = ConstantUtils.SCREENSHOT_DIRECTORY + "screenshot_" + timestamp.getTime() +  ".png";
        try {
            FileUtils.copyFile(screenshotFile,
                    new File(filename));
        } catch (IOException e) {
            System.out.println("File could not be saved on the disk!!");
        }
        return filename;
    }

//    public static void takeScreenshot(WebDriver driver) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotFile,
//                    new File(ConstantUtils.SCREENSHOT_DIRECTORY + "screenshot_" + timestamp.getTime() +  ".png"));
//        } catch (IOException e) {
//            System.out.println("File could not be saved on the disk!!");
//        }
//    }

    public static String getReportName () {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "extentReport_" + timestamp.getTime() + "html";
    }


}
