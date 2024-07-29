package Tests.DemoApp;

import Pages.DemoApp.AlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.DemoApp.MainPage;

public class AlertTests extends BaseTest {

    @Test
    public void AlertTest01() {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
//        Assert if main page is correct
        Assert.assertEquals(mp.getMainPageSelectorText(),"Practice Applications and Pages For Automating and Testing");
        mp.goToAlertsPage();

        AlertPage ap = new AlertPage(driver);
//        Assert if alert page is correct
        Assert.assertEquals(ap.getAlertPageSelectorText(), "Alert Box Examples");
        ap.clickAlertButton();
        ap.acceptAlertBox();
        ap.clickConfirmButton();
        ap.dismissAlertBox();
        ap.clickPromptButton();
        ap.inputAcceptAlert("Me again");

    }
}
