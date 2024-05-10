import Utils.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;
import javax.swing.text.Utilities;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver; //global variable driver of type WebDriver to be visible in all tests
    String browser = "chrome";

    @BeforeTest
    public void beforeTest() {

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }


//        if (browser.equals("chrome")) {
//
//            WebDriverManager.chromedriver().setup(); //run WebDriverManager on the Chrome browser, we use the static method chromedriver() by invoking the setup() method
//            driver = new ChromeDriver(); // initialize the WebDriver object for the Chrome driver > start Chrome browser
//        }
//        else if (browser.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        else {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }
    }

    @AfterTest (enabled = false)
    public void afterTest() {
        driver.quit(); //will close the website

    }

    @Test(enabled = false)
    public void myFirstSeleniumTest() throws InterruptedException {
//        WebDriverManager.chromedriver().setup(); //moved to beforeTest() method as precondition
//        WebDriver driver = new ChromeDriver(); //new instance of ChromeDriver object, polymorphism > a subclass ChromeDriver from superclass WebDriver type
        //moved to beforeTest() method as precondition
        driver.manage().window().maximize(); //browser window maximized
        driver.navigate().to("https://practicetestautomation.com/practice-test-exceptions/"); //navigate to url
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait on all page elements
        WebElement rowTwoConfirmation = driver.findElement(By.id("confirmation"));
        Assert.assertEquals(rowTwoConfirmation.getText(),"Row 2 was added");

//        Thread.sleep(500);  // not recommended as wait


//        driver.quit(); //will close the website moved to afterTest() as post condition

    }

    @Test (enabled = false)
    public void testExplicitWait() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //define explicit wait object
        WebElement removeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove_btn"))); // wait for button
        removeButton.click();
        WebElement rowTwoConfirmation = driver.findElement(By.id("confirmation"));
        Assert.assertEquals(rowTwoConfirmation.getText(),"Row 2 was removed");
    }

    @Test
    public void testExplicitWaitWithWaitMethod() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();
//        find element with method from Utilities
        WebElement removeButton = BrowserUtilities.waitForGenericElement(driver, By.id("remove_btn"), Duration.ofSeconds(5));
        removeButton.click();
//        Assert with method from Utilities
        BrowserUtilities.waitforTextOnSite(driver, By.id("confirmation"), Duration.ofSeconds(1), "Row 2 was removed");
        WebElement rowTwoConfirmation = driver.findElement(By.id("confirmation"));
        Assert.assertEquals(rowTwoConfirmation.getText(),"Row 2 was removed","Text assert pass");
        System.out.println(rowTwoConfirmation.isDisplayed()); //return true if element is displayed
        System.out.println(rowTwoConfirmation.isEnabled()); //return true if element is selected
        System.out.println(rowTwoConfirmation.isSelected()); //return true if element is selected
        System.out.println(rowTwoConfirmation.getAttribute("id")); //print element id
        System.out.println(rowTwoConfirmation.getText()); //print element text
        System.out.println(rowTwoConfirmation.getCssValue("font-family")); // print css attribute eg font-family
        System.out.println(rowTwoConfirmation.getTagName());
    }



    @Test(enabled = false)
    public void mySecondSeleniumTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www-qa2.delhaize.be/");
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());
        Thread.sleep(1000); // not recommended as wait
//        driver.quit(); //will close the website
    }
    //username, password123, message
    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"123", "Password123", "Your username is invalid!"}); //test case
        dp.add(new String[] {"student", "123", "Your password is invalid!"});
//        dp.add(new String[] {"student", "Password123", "Logged In Successfully"});
        return dp.iterator();
    }

    @Test(dataProvider = "loginData", enabled = false)
    public void basicLoginTest(String username, String password, String infoMessage) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());
//        Create an object of type WebElement By xPath
        WebElement pageTextXpath = driver.findElement(By.xpath("//*[@id=\"login\"]/h2")); // save the result in an element of WebElement type
        System.out.println("--------------------");
        System.out.println(pageTextXpath.getText());
        Assert.assertEquals(pageTextXpath.getText(), "Test login"); //check if text is correct
        System.out.println("--------------------");

//        By css selector
        WebElement pageTextCss = driver.findElement(By.cssSelector("#login > h2"));
        Assert.assertEquals(pageTextCss.getText(), "Test login");

//        create a list of elements with same locator > id
        List<WebElement> elements = driver.findElements(By.id("main-container"));
        System.out.println("Elements by id: " + elements.size()); //prints the number of elements with same id
//        System.out.println(elements.get(0).getText());
//        Assert.assertEquals(elements.get(0).getText(), "Login");

//        Get list of elements with same locator > name
        List<WebElement> elementsByLabel = driver.findElements(By.name("username"));
        System.out.println("Elements by name: " + elements.size()); //prints the number of elements with same name

//        Get list of elements with same locator > class name
        List<WebElement> elementsByClass = driver.findElements(By.className("main-container"));
        System.out.println("Elements by class name: " + elementsByClass.size()); //prints the number of
        // elements with same class name
//        System.out.println(elementsByClass.get(0).getText());

//        Login form
        WebElement usernameLabel = driver.findElement(By.cssSelector("#form > div:nth-child(1) > label"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("#form > div:nth-child(2) > label"));

        Assert.assertEquals(usernameLabel.getText(),"Username", "Username label is correct");
        Assert.assertEquals(passwordLabel.getText(),"Password", "Password label is correct");

//        Login with username and password
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.clear(); //clear username field before sendKeys()
        passwordInput.clear(); //clear password field before sendKeys()
//        username and password hard coded
//        usernameInput.sendKeys("student");
//        passwordInput.sendKeys("Password123");

//        username and password dynamic from data provider
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//        WebElement loginSuccess = driver.findElement(By.className("post-title"));
//        System.out.println(loginSuccess.getText());
//        Assert.assertEquals(loginSuccess.getText(), "Logged In Successfully"); // hard coded assert if successful login
//        Assert.assertEquals(loginSuccess.getText(), infoMessage); // dynamic assert

        WebElement usernameError = driver.findElement(By.id("error"));
//        Assert.assertEquals(usernameError.getText(), ""); // assert if username is valid
//        Assert.assertEquals(usernameError.getText(), "Your username is invalid!"); // assert if username is invalid
        Assert.assertEquals(usernameError.getText(), infoMessage); // dynamic assert


        WebElement passwordError = driver.findElement(By.id("error"));
//        Assert.assertEquals(passwordError.getText(), ""); // assert if password is valid
//        Assert.assertEquals(passwordError.getText(), "Your password is invalid!"); // assert if password is invalid
        Assert.assertEquals(passwordError.getText(), infoMessage); // dynamic assert

        Thread.sleep(500); // not recommended as wait
    }

    @Test
    public void basicRegisterTest() {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.clear(); //clear username field before sendKeys()
        passwordInput.clear(); //clear password field before sendKeys()
        usernameInput.sendKeys(BrowserUtilities.createRandomStringOne(5));
        passwordInput.sendKeys(BrowserUtilities.createRandomStringTwo(5));
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement loginSuccess = driver.findElement(By.className("post-title"));
        Assert.assertEquals(loginSuccess.getText(), "Logged In Successfully");

    }




}
