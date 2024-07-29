package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage extends BasePage {

    private String hoverPageSelector = "body > div > h1"; //css
    private String hoverButtonSelector = "hoverdivpara"; //id
    private String hoverParaEffectSelector = "hoverdivparaeffect"; //id
    private String hoverLinkSelector = "hoverlink"; //id
    private String hoverActionCompleteSelector = "body > div > div.explanation > p"; //css
    private String returnLinkSelector = "returnlink"; //id


    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public String getHoverPageSelectorText() {
        return driver.findElement(By.cssSelector(hoverPageSelector)).getText();
    }
    public String getHoverButtonSelectorText() {
        return driver.findElement(By.id(hoverButtonSelector)).getText();
    }
    public String getHoverEffectSelectorText() {
        return driver.findElement(By.id(hoverParaEffectSelector)).getText();
    }
    public String getHoverParaEffectSelectorText() {
        return driver.findElement(By.id(hoverParaEffectSelector)).getText();
    }
    public String getHoverLinkSelectorText() {
        return driver.findElement(By.id(hoverLinkSelector)).getText();
    }
    public String getHoverActionCompleteSelectorText() {
        return driver.findElement(By.cssSelector(hoverActionCompleteSelector)).getText();
    }

    public void clickHoverButton() { //Actions class for Hover button
        WebElement hoverButton = driver.findElement(By.id(hoverButtonSelector));
        hoverButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform(); //click on Hover
    }

    public void clickHoverLink() {
        driver.findElement(By.id(hoverLinkSelector)).click();
    }

    public void clickReturnLink() {
        driver.findElement(By.id(returnLinkSelector)).click();
    }



}
