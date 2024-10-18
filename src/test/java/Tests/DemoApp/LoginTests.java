package Tests.DemoApp;

import Pages.DemoApp.LoginPOMPage;
import Pages.DemoApp.LoginPage;
import Tests.DataTests.BaseTest;
import Utils.ExtentTestManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class LoginTests extends BaseTest {

    //Test with Page Factory with Asserts outside of Page Objects class

    @Test (groups = {"Smoke"})
    public void loginPositiveTest(Method method) {
        ExtentTestManager.startTest(method.getName(), "");
        driver.get(baseUrl + "practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password123"); //use constructor with 2 params
        Assert.assertEquals(loginPage.getLoginSuccessMessage(), "Logged In Successfully");
    }

      //Test with Page Factory with Asserts inside of Page Objects class
    @Test (enabled = false)
    public void loginPositive2Test() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password123", "Logged In Successfully", ""); //use constructor with 4 params
    }

    //Test with Page Object Model with Asserts inside and outside of Page Objects class
    @Test (enabled = true)
    public void loginPositivePOMTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPOMPage loginPage = new LoginPOMPage(driver);
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password123"); //use constructor with 2 params
        Assert.assertEquals(loginPage.getLoginSuccessMessage(), "Logged In Successfully");
    }

    //username, password123, message
    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"123", "Password123", "Your username is invalid!"}); //test case
        dp.add(new String[] {"student", "123", "Your password is invalid!"});
//        dp.add(new String[] {"student", "Password123", "Logged In Successfully"});
        return dp.iterator();
    }
    //Test with Page Object model and Data Provider
    @Test (dataProvider = "loginData")
    public void loginWithDataProviderTest(String username, String password, String infoMessage) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPOMPage loginPage = new LoginPOMPage(driver);
        loginPage.verifyPage(); //assert on page
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getUsernameError(), infoMessage);
        Assert.assertEquals(loginPage.getPasswordError(), infoMessage);

    }

    //Test with Page Factory with Asserts outside of Page Objects class
    @Test (groups = {"Smoke"})
    public void loginNegativeUsernameTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //reflection
        loginPage.verifyPage(); //assert on page
        loginPage.login("student1", "Password123");
        Assert.assertEquals(loginPage.getUsernameError(), "Your username is invalid!");
    }

    //Test with Page Factory with Asserts inside of Page Objects class
    @Test (enabled = false)
    public void loginNegativeUsername2Test() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //reflection
        loginPage.verifyPage(); //assert on page
        loginPage.login("student1", "Password123","Your username is invalid!","");
    }

    //Test with Page Object Model with Asserts inside Page Object class
    @Test (enabled = true)
    public void loginNegativeUsername2POMTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPOMPage loginPage = new LoginPOMPage(driver);
        loginPage.verifyPage(); //assert on page
        loginPage.login("student1", "Password123");
//        Assert.assertEquals(loginPage.getUsernameError(), "Your username is invalid!");
    }

    //Test with Page Factory with Asserts outside of Page Objects class
    @Test (enabled = true)
    public void loginNegativePasswordTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //reflection
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password1234");
        Assert.assertEquals(loginPage.getPasswordError(), "Your password is invalid!");
    }

    //Test with Page Factory with Asserts inside of Page Objects class
    @Test (enabled = false)
    public void loginNegativePassword2Test() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //reflection
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password1234","","Your password is invalid!");
    }

}
