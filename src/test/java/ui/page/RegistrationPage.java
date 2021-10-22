package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.base.BasePage;

public class RegistrationPage extends BasePage {

    private final By byRegistrationUsername = By.cssSelector("#mat-input-0");
    private final By byRegistrationName = By.cssSelector("#mat-input-1");
    private final By byRegistrationLastname = By.cssSelector("#mat-input-2");
    private final By byRegistrationPassword = By.cssSelector("#mat-input-3");
    private final By byConfirmRegistrationPassword = By.cssSelector("#mat-input-4");
    private final By byRegistrationButton = By.cssSelector(".mat-button-wrapper");
    private final By bySigninButton = By.cssSelector(".register-page > div:nth-child(2) > a:nth-child(1)");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setRegistrationUsername(String username) {
        driver.findElement(byRegistrationUsername).sendKeys(username);
        return this;
    }

    public RegistrationPage setRegistrationName(String name) {
        driver.findElement(byRegistrationName).sendKeys(name);
        return this;
    }

    public RegistrationPage setRegistrationLastname(String lastname) {
        driver.findElement(byRegistrationLastname).sendKeys(lastname);
        return this;
    }

    public RegistrationPage setRegistrationPassword(String password) {
        driver.findElement(byRegistrationPassword).sendKeys(password);
        return this;
    }
    public RegistrationPage setConfirmRegistrationPassword(String confirmpassword) {
        driver.findElement(byConfirmRegistrationPassword).sendKeys(confirmpassword);
        return this;
    }
    public RegistrationPage clickRegistrationButton() {
        driver.findElement(byRegistrationButton).click();
        return new RegistrationPage (driver);
    }
    public SigninPage clickSigninButton() {
        driver.findElement(bySigninButton).click();
        return new SigninPage (driver);
    }
}
