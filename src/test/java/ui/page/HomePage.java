package ui.page;

import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By byLoginLink = By.linkText("Log in");
    private By byRegistrationLink = By.linkText("Create account");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(byLoginLink).click();
        return new LoginPage(driver);
    }

    public RegistrationPage goToRegistrationPage() {
        driver.findElement(byRegistrationLink).click();
        return new RegistrationPage(driver);
    }

}
