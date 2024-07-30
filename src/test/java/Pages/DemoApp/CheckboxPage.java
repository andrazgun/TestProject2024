package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckboxPage extends BasePage {

    private String checkboxPageSelector = "#content > div > h3"; //css
    private String checkboxOneSelector = "#checkboxes > input[type=checkbox]:nth-child(1)"; //css
    private String checkboxTwoSelector = "#checkboxes > input[type=checkbox]:nth-child(3)"; //css


    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public String getCheckboxPageSelectorText() {
        return driver.findElement(By.cssSelector(checkboxPageSelector)).getText();
    }

    public String getCheckboxOneSelectorText() {
        return driver.findElement(By.cssSelector(checkboxOneSelector)).getText();
    }

    public String getCheckboxTwoSelectorText() {
        return driver.findElement(By.cssSelector(checkboxTwoSelector)).getText();
    }

    public void clickCheckboxOne() { // using Actions Class
        WebElement checkboxOne = driver.findElement(By.cssSelector(checkboxOneSelector));
        Actions actions = new Actions(driver);
        actions.click(checkboxOne).build().perform();
    }

    public void unclickCheckboxOne() {
        WebElement checkboxOne = driver.findElement(By.cssSelector(checkboxOneSelector));
        checkboxOne.click();
    }
    public void clickCheckboxTwo() {
        WebElement checkboxOne = driver.findElement(By.cssSelector(checkboxTwoSelector));
        Actions actions = new Actions(driver);
        actions.click(checkboxOne).build().perform();
    }

    public void unclickCheckboxTwo() {
        WebElement checkboxOne = driver.findElement(By.cssSelector(checkboxTwoSelector));
        checkboxOne.click();
    }
    public Boolean isCheckboxOneSelected() {
        return driver.findElement(By.cssSelector(checkboxOneSelector)).isSelected();
    }
    public Boolean isCheckboxTwoSelected() {
        return driver.findElement(By.cssSelector(checkboxTwoSelector)).isSelected();
    }
}
