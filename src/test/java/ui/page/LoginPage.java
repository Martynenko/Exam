package ui.page;

import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By byUsername = By.cssSelector("#mat-input-0");
    private final By byPassword = By.cssSelector("#mat-input-1");
    private final By byLoginButton = By.cssSelector(".mat-button-wrapper");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setUsername(String username) {
        driver.findElement(byUsername).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(byPassword).sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        driver.findElement(byLoginButton).click();
        return new MainPage(driver);
    }
}
