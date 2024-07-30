package Tests.DemoApp;

import Pages.DemoApp.CheckboxPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTests extends BaseTest {

    @Test
    public void CheckBoxTest01() {
        CheckboxPage cp = new CheckboxPage(driver);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertEquals(cp.getCheckboxPageSelectorText(),"Checkboxes");
        Assert.assertEquals(driver.findElement(By.id("checkboxes")).isEnabled(),true);
        Assert.assertEquals(driver.findElement(By.id("checkboxes")).isDisplayed(), true);

        cp.clickCheckboxOne();
        Assert.assertEquals(cp.isCheckboxOneSelected(), true);
        cp.unclickCheckboxOne();
        Assert.assertEquals(cp.isCheckboxOneSelected(), false);

        cp.unclickCheckboxTwo();
        Assert.assertEquals(cp.isCheckboxTwoSelected(), false);
        cp.clickCheckboxTwo();
        Assert.assertEquals(cp.isCheckboxTwoSelected(), true);
    }

}
