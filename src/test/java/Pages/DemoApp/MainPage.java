package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private String alertUrlSelector = "alerttest"; //id
    private String hoverUrlSelector = "csspseudohover"; //id
    private String mainPageSelector = "body > div > h1"; //css

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMainPageSelectorText() {
        return driver.findElement(By.cssSelector(mainPageSelector)).getText();
    }

    public void goToAlertsPage() {
        driver.findElement(By.id(alertUrlSelector)).click();
    }

    public void goToHoverPage() {
        driver.findElement(By.id(hoverUrlSelector)).click();
    }


}
