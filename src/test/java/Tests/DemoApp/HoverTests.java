package Tests.DemoApp;

import Pages.DemoApp.HoverPage;
import Tests.DataTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.DemoApp.MainPage;

public class HoverTests extends BaseTest {

    @Test
    public void HoverTest01() {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getMainPageSelectorText(),"Practice Applications and Pages For Automating and Testing");
        mp.goToHoverPage();

        HoverPage hp = new HoverPage(driver);
        Assert.assertEquals(hp.getHoverPageSelectorText(),"CSS Pseudo Class - hover");
        hp.clickHoverButton();
        Assert.assertEquals(hp.getHoverEffectSelectorText(),"You can see this child div content now that you hovered on the above 'button'.");
        Assert.assertEquals(hp.getHoverLinkSelectorText(),"Can you click me?");
        hp.clickHoverLink();
        Assert.assertEquals(hp.getHoverActionCompleteSelectorText(),"You performed the action suggested to you.");
        hp.clickReturnLink();
        Assert.assertEquals(hp.getHoverPageSelectorText(),"CSS Pseudo Class - hover");

    }
}
