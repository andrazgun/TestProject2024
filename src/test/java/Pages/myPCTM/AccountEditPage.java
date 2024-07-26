package Pages.myPCTM;

import Pages.DemoApp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountEditPage extends BasePage {

    private String accountInfoSelector = "#content > h1 > strong";
    private String personalDataSelector = "#content > form > div.page-content > h4"; //css
    private String surnameLabelSelector = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[1]/td[1]/text()"; //xpath
    private String surnameInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(1) > td:nth-child(2) > input[type=text]"; //css
    private String nameLabelSelector = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[2]/td[1]/text()"; //xpath
    private String nameInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=text]"; //css
    private String emailLabelSelector = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[3]/td[1]/text()"; //xpath
    private String emailInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=text]"; //css
    private String phoneLabelSelector = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[4]/td[1]/text()"; //xpath
    private String phoneInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(4) > td:nth-child(2) > input[type=text]"; //css
    private String submitButtonSelector = "#content > form > div.buttons > div.right > input"; //css


    public AccountEditPage(WebDriver driver) {

        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(accountInfoSelector)).getText(), "INFORMATII CONT");
        Assert.assertEquals(driver.findElement(By.cssSelector(personalDataSelector)).getText(), "Date personale");
//        Assert.assertEquals(driver.findElement(By.xpath(surnameLabelSelector)).getText(), "Prenume:");
//        Assert.assertEquals(driver.findElement(By.xpath(nameLabelSelector)).getText(), "Nume de familie:");
//        Assert.assertEquals(driver.findElement(By.xpath(emailLabelSelector)).getText(), "E-Mail:");
//        Assert.assertEquals(driver.findElement(By.xpath(phoneLabelSelector)).getText(), "Telefon:");
    }

    public void editAccountDetails (String surname, String name, String email, String phone) {
        WebElement surnameElement = driver.findElement(By.cssSelector(surnameInputSelector));
        WebElement nameElement = driver.findElement(By.cssSelector(nameInputSelector));
        WebElement emailElement = driver.findElement(By.cssSelector(emailInputSelector));
        WebElement phoneElement = driver.findElement(By.cssSelector(phoneInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        surnameElement.clear();
        surnameElement.sendKeys(surname);
        nameElement.clear();;
        nameElement.sendKeys(name);
        emailElement.clear();
        emailElement.sendKeys(email);
        phoneElement.clear();
        phoneElement.sendKeys(phone);
        submitButton.click();

    }

}