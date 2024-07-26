package Tests.myPCTM;

import Utils.GenericUtils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import Utils.SeleniumUtils;
import java.util.Set;

public class CookiesTests extends BaseTest{

    @Test
    public void cookieTest01() {

        driver.get(baseUrl);
        GenericUtils.printCookies(driver);
        SeleniumUtils.takeScreenshot(driver);
    }

    @Test
    public void cookieTest02() {
        driver.get(baseUrl);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size()); //initial cookie count eg 6
        Cookie c1 = new Cookie("myCookie", "my cookie value");
        driver.manage().addCookie(c1);
        System.out.println(driver.manage().getCookies().size()); //final cookie count eg 7
//        GenericUtils.printCookies(driver);
        driver.manage().deleteCookieNamed("myCookie");
        System.out.println(driver.manage().getCookies().size());
        System.out.println("Is cookie present? " + SeleniumUtils.checkIfCookieExistsByName(driver, "_gat"));
        driver.manage().deleteCookieNamed("_gat");
        System.out.println("Is cookie present? " + SeleniumUtils.checkIfCookieExistsByName(driver, "_gat"));
        System.out.println(driver.manage().getCookies().size());
        Cookie c2 = driver.manage().getCookieNamed("_ga");
        System.out.println(c2);

        driver.manage().deleteAllCookies(); //delete all cookies
        System.out.println(driver.manage().getCookies().size());
    }
}