package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.base.BasePage;


public class ProfilePage extends BasePage {
    private final By byEditInfo = By.cssSelector(".user-profile > div:nth-child(2) > button:nth-child(1)");
    private final By byName = By.cssSelector("#mat-input-2");
    private final By byLastname = By.cssSelector("#mat-input-3");
    private final By byUpdateButton = By.cssSelector("button.w-50:nth-child(2) > span:nth-child(1)");
    private final By byUserData = By.cssSelector("div.col:nth-child(2) > h3:nth-child(2)");
    private final By byAddJobButton = By.cssSelector(".my-jobs > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)");
    private final By byTitle = By.cssSelector("#mat-input-2");
    private final By byDescription = By.cssSelector("#mat-input-3");
    private final By byPrice = By.cssSelector("#mat-input-4");
    private final By byCreateJobButton = By.cssSelector("form.ng-touched > div:nth-child(4) > button:nth-child(1) > span:nth-child(1)");
    private final By byCloseProfileButton = By.cssSelector("button.mat-focus-indicator:nth-child(2) > span:nth-child(1)");
    private final By byTextTitle = By.cssSelector("mat-card.mat-card:nth-child(1) > mat-card-header:nth-child(1) > div:nth-child(1) > mat-card-title:nth-child(1)");
    private final By byTextDescription = By.cssSelector("mat-card.mat-card:nth-child(1) > mat-card-content:nth-child(4) > p:nth-child(1)");
    private final By byTextPrice = By.cssSelector("mat-card.mat-card:nth-child(1) > mat-card-subtitle:nth-child(3)");
    private final By byCheckTitle = By.cssSelector("mat-card.mat-card:nth-child(3) > mat-card-header:nth-child(1) > div:nth-child(1) > mat-card-title:nth-child(1)");
    private final By byCheckComments = By.cssSelector("mat-card.mat-card:nth-child(3) > mat-card-subtitle:nth-child(2) > mat-card-subtitle:nth-child(1)");
    private final By byCheckPrice = By.cssSelector("mat-card.mat-card:nth-child(3) > mat-card-subtitle:nth-child(2) > mat-card-subtitle:nth-child(2)");
    private final By byCheckDescription = By.cssSelector("mat-card.mat-card:nth-child(3) > mat-card-content:nth-child(3) > p:nth-child(1)");
    private final By byRemoveButton = By.cssSelector("mat-card.mat-card:nth-child(3) > mat-card-actions:nth-child(4) > button:nth-child(1) > span:nth-child(1)");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage clickEditInfoButton() {
        driver.findElement(byEditInfo).click();
        return new ProfilePage(driver);
    }

    public ProfilePage clearFieldName() {
        driver.findElement(byName).clear();
        return new ProfilePage(driver);
    }

    public ProfilePage setName(String name) {
        driver.findElement(byName).sendKeys(name);
        return new ProfilePage(driver);
    }

    public ProfilePage clearFieldLastame() {
        driver.findElement(byLastname).clear();
        return new ProfilePage(driver);
    }

    public ProfilePage setLastname(String lastname) {
        driver.findElement(byLastname).sendKeys(lastname);
        return new ProfilePage(driver);
    }

    public ProfilePage clickUpdateButton() {
        driver.findElement(byUpdateButton).click();
        return new ProfilePage(driver);
    }

    public String checkUserdata() {
        return driver.findElement(byUserData).getText();
    }

    public ProfilePage clickAddJobButton() {
        driver.findElement(byAddJobButton).click();
        return new ProfilePage(driver);
    }

    public ProfilePage setTitle(String title) {
        driver.findElement(byTitle).sendKeys(title);
        return new ProfilePage(driver);
    }

    public ProfilePage setDescription(String description) {
        driver.findElement(byDescription).sendKeys(description);
        return new ProfilePage(driver);
    }

    public ProfilePage setPrice(String price) {
        driver.findElement(byPrice).sendKeys(price);
        return new ProfilePage(driver);
    }

    public ProfilePage clickCreateJobButton() {
        driver.findElement(byCreateJobButton).click();
        return new ProfilePage(driver);
    }

    public ProfilePage clickCloseProfileButton() {
        driver.findElement(byCloseProfileButton).click();
        return new ProfilePage(driver);
    }

    public String checkTextTitle() {
        return driver.findElement(byTextTitle).getText();
    }

    public String checkTextDescription() {
        return driver.findElement(byTextDescription).getText();
    }

    public String checkTextPrice() {
        return driver.findElement(byTextPrice).getText();
    }

    public String checkTitle() {
        return driver.findElement(byCheckTitle).getText();
    }

    public String checkComments() {
        return driver.findElement(byCheckComments).getText();
    }

    public String checkPrice() {
        return driver.findElement(byCheckPrice).getText();
    }

    public String checkDescription() {
        return driver.findElement(byCheckDescription).getText();
    }

    public ProfilePage clickRemoveButton() {
        driver.findElement(byRemoveButton).click();
        driver.switchTo().alert().accept();
        return new ProfilePage(driver);
    }

}
