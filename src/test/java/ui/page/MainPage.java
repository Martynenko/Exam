package ui.page;

import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    private final By byProfile = By.cssSelector(".mat-accent");
    private final By byProfileButton = By.cssSelector("button.mat-menu-item:nth-child(1)");
    private final By byLogout = By.cssSelector("button.mat-focus-indicator:nth-child(2)");
    private final By byViewInfoButton = By.cssSelector("mat-card.mat-card:nth-child(1) > mat-card-actions:nth-child(5) > button:nth-child(1) > span:nth-child(1)");
    private final By byViewInfoButton2 = By.cssSelector("mat-card.mat-card:nth-child(1) > mat-card-actions:nth-child(5) > button:nth-child(1) > span:nth-child(1)");
    private final By byCheckComment = By.cssSelector("mat-card-content.mat-card-content:nth-child(3) > p:nth-child(1)");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickProfile() {
        driver.findElement(byProfile).click();
        return new MainPage(driver);
    }

    public ProfilePage clickProfileButton() {
        driver.findElement(byProfileButton).click();
        return new ProfilePage(driver);
    }
    public String checkButtonLogout() {
        return driver.findElement(byLogout).getText();
    }

    public JobPage clickViewInfoButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(byViewInfoButton).click();
        return new JobPage(driver);
    }
    public String checkComment() {
        return driver.findElement(byCheckComment).getText();
    }

    public MainPage clickViewInfoButton2() {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(byViewInfoButton2).click();
        return new MainPage(driver);
    }
}
