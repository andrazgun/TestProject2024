package Pages.DemoApp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    private String alertButtonSelector = "alertexamples"; //id
    private String confirmButtonSelector = "confirmexample"; //id
    private String promptButtonSelector = "promptexample"; //id
    private String alertPageSelector = "body > div > h1"; //css

    public AlertPage(WebDriver driver) {
        super(driver);
    }
    public String getAlertPageSelectorText() {
        return driver.findElement(By.cssSelector(alertPageSelector)).getText();
    }
    public void clickAlertButton() {
        driver.findElement(By.id(alertButtonSelector)).click();
    }

    public void acceptAlertBox() { //class to accept the Alert box
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    public void dismissAlertBox() { //class to dismiss the Alert box
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }
public void inputAcceptAlert(String inputAlert) {
    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.sendKeys(inputAlert);
    alert.accept();
}

    public void clickConfirmButton() {
        driver.findElement(By.id(confirmButtonSelector)).click();
    }
    public void clickPromptButton() {
        driver.findElement(By.id(promptButtonSelector)).click();
    }

}
