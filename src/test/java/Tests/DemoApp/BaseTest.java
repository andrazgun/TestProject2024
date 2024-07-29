package Tests.DemoApp;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    public WebDriver driver;
    String browser = GenericUtils.getBrowserFromConfig(ConstantUtils.CONFIG_FILE);
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);

    @BeforeTest
    public void beforeTest() {
        System.out.println(baseUrl);
        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
//        driver = BrowserUtils.getBrowser(BrowserTypes.CHROME).getDriver(); //another way to initialize the browser type

    }

    @AfterTest(enabled = false)
    public void afterTest() {
        driver.quit();

    }

}
