package Pages.DemoApp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import java.util.List;

//This is with Page Factory design pattern
public class LoginPage {

//    Find by XPath selector
    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/h2")
    private WebElement pageTextXpath;

//    Find by CSS selector
    @FindBy(how = How.CSS, using = "#login > h2")
    private WebElement pageTextCss;

//    Find the web element from a list using more than one criteria, ID or class
    @FindAll
            ({
            @FindBy(how = How.ID, using = "main-container"),
            @FindBy(className = "main-container"), //alternative syntax to find by class name
            @FindBy(how = How.CLASS_NAME, using = "main-container") //alternative syntax to find by class name
            })
        private List<WebElement> elements;

    //    Find by tag selector
    @FindBy(how = How.TAG_NAME, using = "Test login")
    private WebElement pageTextTag;



//    Find by ID selector
    @FindBy(how = How.ID, using = "login")
    private WebElement pageTextId;

    @FindBy(how = How.CSS, using = "#form > div:nth-child(1) > label")
    private WebElement usernameLabel;

    @FindBy(how = How.CSS, using = "#form > div:nth-child(2) > label")
    private WebElement passwordLabel;

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    @FindBy(how = How.ID, using = "error")
    private WebElement usernameError;

    @FindBy(how = How.ID, using = "error")
    private WebElement passwordError;

    @FindBy(how = How.CLASS_NAME, using = "post-title")
    private WebElement loginSuccess;


    public void verifyPage() {
//        Assert.assertEquals(pageTextXpath.getText(), "Test login");
        Assert.assertEquals(pageTextCss.getText(), "Test login");
        Assert.assertEquals(usernameLabel.getText(),"Username", "Username label is correct");
        Assert.assertEquals(passwordLabel.getText(),"Password", "Password label is correct");
    }

    public void login(String username, String password, String userError, String passError) {
        login(username, password); //method overloading

        Assert.assertEquals(usernameError.getText(), userError);
        Assert.assertEquals(passwordError.getText(), passError);
    }

    public void login(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
    }
//Getter method for Assert in test
    public String getUsernameError() {
        return usernameError.getText();
    }
    //Getter method for Assert in test
    public String getPasswordError() {
        return passwordError.getText();
    }

    public String getLoginSuccessMessage() {
        return loginSuccess.getText();
    }


}
