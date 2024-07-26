package Tests.DemoApp;

import Pages.DemoApp.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{


    @Test
    public void registrationTest() {

        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyPage(); //assert on page
        loginPage.login("student", "Password123"); //use constructor with 2 params
        Assert.assertEquals(loginPage.getLoginSuccessMessage(), "Logged In Successfully");

    }

}