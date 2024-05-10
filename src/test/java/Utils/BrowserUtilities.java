package Utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;
import java.util.regex.Pattern;

public class BrowserUtilities {

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
    //random String method
    public static String createRandomStringOne(int charCount) {
        StringBuilder sb = new StringBuilder();
        String charset = "abc123!@#";
        for (int i = 0; i < charCount; i++) {
            Random r = new Random();
            char x = charset.toCharArray()[r.nextInt(charset.length())]; //takes x as random char and append to sb
            sb.append(x);
        }
        System.out.println(sb);
        return sb.toString();
    }
    public static String createRandomStringTwo(int stringLength) {
        String rs = RandomStringUtils.randomAlphanumeric(stringLength);
        System.out.println(rs);
        return rs;
    }

}
