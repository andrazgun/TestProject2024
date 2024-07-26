package Pages.DemoApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait on sub pages *DEPRECATED*
    }


}
