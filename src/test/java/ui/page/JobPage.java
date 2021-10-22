package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.base.BasePage;

public class JobPage extends BasePage {
    private final By byComment = By.cssSelector("#mat-input-2");
    private final By byLeaveCommentButton = By.cssSelector("mat-card.mat-card:nth-child(2) > div:nth-child(4) > button:nth-child(1) > span:nth-child(1)");
    private final By byCloseJobButton = By.cssSelector(".job-page > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)");

    public JobPage(WebDriver driver) {
        super(driver);
    }


    public JobPage setComment(String comment) {
        driver.findElement(byComment).sendKeys(comment);
        return this;
    }

    public JobPage clickLeaveCommentButton() {
        driver.findElement(byLeaveCommentButton).click();
        return new JobPage(driver);
    }
    public MainPage clickCloseJobButton() {
        driver.findElement(byCloseJobButton).click();
        return new MainPage(driver);
    }

}
