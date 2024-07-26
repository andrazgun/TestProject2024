package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserUtils {

    public static WebDriver getBrowser(String browser, String configFile) {

        switch (browser.toLowerCase()) {
            case ("chrome") : {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptionsFromConfig(ConstantUtils.CONFIG_FILE_2)); // used to accept self-signed or insecure certificates in the test env
//                options.addArguments("headless"); //start browser in headless mode (without a visible UI, the app in the background)
                options.addArguments("start-maximized"); //start browser in maximized window
                options.addArguments("incognito"); //start in incognito
                options.addArguments("disable-popup-blocking");

//              Setting a proxy server if set to true
                if(GenericUtils.isProxyEnabled(ConstantUtils.CONFIG_FILE_2)) {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(
                            ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE_2, "proxyAddress", "127.0.0.1") + ":" +
                            ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE_2,"proxyPort","8081"));
                    options.setProxy(proxy); //start with proxy
                    System.out.println("Proxy enabled: " + proxy);
                }
//

//                 Setting download directory
                if(GenericUtils.isDownloadDirectoryEnabled(ConstantUtils.DOWNLOAD_DIRECTORY)) {
                    Map<String, Object> chromePref = new HashMap<>();
                    chromePref.put("download.default_directory", "src//test//java//Resources");
                    options.setExperimentalOption("prefs", chromePref);
                    }


                return new ChromeDriver(options);
            }
            case ("firefox") : {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                if(GenericUtils.isDownloadDirectoryEnabled(configFile)) {
                    profile.setPreference("browser.download.dir", ConstantUtils.DOWNLOAD_DIRECTORY);
                }

                options.setProfile(profile);
                options.setAcceptInsecureCerts(GenericUtils.getInsecureCertOptionsFromConfig(configFile));



                WebDriver driver = new FirefoxDriver(options);


                if (GenericUtils.startMaximized(configFile))
                    {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.parse(ConfigUtils.getGenericValue(configFile,"implicitWait", "10")));
                    }
                return driver;
            }
            case ("edge") : {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default : {
                System.out.println("Driver not supported");
                return WebDriverManager.getInstance(browser).getWebDriver();
            }

        }

    }

    public static Browser getBrowser(BrowserTypes browserType) {
        switch (browserType) {
            case CHROME : {
                return new ChromeBrowser();
            }
            case FIREFOX : {
                return new FirefoxBrowser();
            }
            case EDGE : {
                return new EdgeBrowser();
            }
            default : {
                System.out.println("Driver not supported");
                return null;
            }
        }
    }

    public static String getBrowserExternal(String propertyName) {
//        Take all the system env names and values
        Map<String, String> env = System.getenv();
//        check if propertyName is set and used it, else set browser to Chrome
        if (env.containsKey(propertyName)) {
            System.out.println("Running from ENV variable with: " + System.getenv(propertyName));
            return System.getenv(propertyName);
        } else {
            return "CHROME";
        }


    }

}
