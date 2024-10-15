package Tests.DataTests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    String browser = GenericUtils.getBrowserFromConfig(ConstantUtils.CONFIG_FILE);

    public WebDriver driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
    public String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE_3);
    String usedConfig = ConstantUtils.CONFIG_FILE_3;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    Base64 base64 = new Base64();

    @BeforeTest
    public void beforeTest() {
        System.out.println(baseUrl);
//        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
//        driver = BrowserUtils.getBrowser(BrowserTypes.CHROME).getDriver(); //another way to initialize the browser type
        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);
    }

    @AfterTest(enabled = false)
    public void afterTest() {
        driver.quit();

    }

}
