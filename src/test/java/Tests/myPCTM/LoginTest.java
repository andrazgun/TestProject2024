package Tests.myPCTM;

import Pages.myPCTM.AccountEditPage;
import Pages.myPCTM.AccountPage;
import Pages.myPCTM.LoginPage;
import Utils.GenericUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Test with Page Factory with Asserts outside of Page Objects class
    @Test
    public void loginBasicTest() {
        driver.get(baseUrl + "/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPage(); //assert on page
        loginPage.login("agtest1@yopmail.com", "Pass123");

        AccountPage ap = new AccountPage(driver);
        ap.verifyPage();
        ap.changeAccountDetails();
        Assert.assertEquals(driver.findElement(By.cssSelector("#content > h1 > strong")).getText(), "INFORMATII CONT");

    }

    @Test
    public void changeAccountDetailsTest() {
        driver.get(baseUrl + "/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPage(); //assert on page
        loginPage.login("agtest1@yopmail.com", "Pass123");

        AccountPage ap = new AccountPage(driver);
        ap.verifyPage();
        ap.changeAccountDetails();

        AccountEditPage aep = new AccountEditPage(driver);
        aep.verifyPage();
        aep.editAccountDetails(GenericUtils.createRandomStringTwo(10), GenericUtils.createRandomStringTwo(10), "agtest1@yopmail.com", "0733111222");
        Assert.assertEquals(driver.findElement(By.cssSelector("#columns > div > div > div.success")).getText(), "Succes: Contul a fost actualizat cu succes.");
    }




}
