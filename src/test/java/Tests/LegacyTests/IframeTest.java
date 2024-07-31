package Tests.LegacyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest {

    private static WebDriver driver;

    public static void main(String[] args) {
        before();
        WebElement iframeElement = driver.findElement(By.cssSelector("#content > article > section:nth-child(3) > div > iframe"));
        driver.switchTo().frame(iframeElement);
        WebElement iFrameTitle = driver.findElement(By.cssSelector("body > header > h4"));
        System.out.println("Iframe text: " + iFrameTitle.getText());
        driver.switchTo().defaultContent();
WebElement mainPageTitleElement = driver.findElement(By.cssSelector("#content > article > header > h1"));
        System.out.println("Main Page title: " + mainPageTitleElement.getText());
        after();

    }

    private static void after() {
        driver.quit();
    }

    public static void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/iframe");
        driver.manage().window().maximize();
    }
}
