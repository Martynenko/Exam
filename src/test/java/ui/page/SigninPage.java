package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.base.BasePage;

public class SigninPage extends BasePage {
    private final By byUsername = By.cssSelector("#mat-input-5");
    private final By byPassword = By.cssSelector("#mat-input-6");
    private final By byLoginButton = By.cssSelector(".mat-button-wrapper");

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    public SigninPage setUsername(String username) {
        driver.findElement(byUsername).sendKeys(username);
        return this;
    }

    public SigninPage setPassword(String password) {
        driver.findElement(byPassword).sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        driver.findElement(byLoginButton).click();
        return new MainPage(driver);
    }
}
