package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//This is classic Page Object Model design pattern
public class LoginPOMPage extends BasePage {

    private final String pageTextXpath = "//*[@id=\"login\"]/h2";
    private final String pageTextCss = "#login > h2";
    private String pageTextTag = "Test login";
    private String pageTextId = "login";
    private String usernameLabel = "#form > div:nth-child(1) > label";
    private String passwordLabel = "#form > div:nth-child(2) > label";
    private String usernameInputId = "username";
    private String passwordInputId = "password";
    private String submitButtonId = "submit";
    private String usernameError = "error";
    private String passwordError = "error";
    private String loginSuccess = "post-title";

    public LoginPOMPage(WebDriver driver) {
        super(driver); //takes driver from super class
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath(pageTextXpath)).getText(), "Test login");
        Assert.assertEquals(driver.findElement(By.cssSelector(pageTextCss)).getText(), "Test login");
        Assert.assertEquals(driver.findElement(By.cssSelector(usernameLabel)).getText(),"Username", "Username label is correct");
        Assert.assertEquals(driver.findElement(By.cssSelector(passwordLabel)).getText(),"Password", "Password label is correct");
    }

    public void login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id(usernameInputId));
        WebElement passwordInput = driver.findElement(By.id(passwordInputId));
        WebElement submitButton = driver.findElement(By.id(submitButtonId));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();

    }

    public String getUsernameError() {
        return driver.findElement(By.id(usernameError)).getText();
    }
    //Getter method for Assert in test
    public String getPasswordError() {
        return driver.findElement(By.id(passwordError)).getText();
    }

    public String getLoginSuccessMessage() {
        return driver.findElement(By.className(loginSuccess)).getText();
    }

}
