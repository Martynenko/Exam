package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.page.HomePage;
import ui.page.MainPage;

public class CommentTest extends BaseTest {
    @Test
    public void commentTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        MainPage mainPage = new HomePage(driver).goToLoginPage()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickViewInfoButton()
                .setComment("Test of Martynenko Artem")
                .clickLeaveCommentButton()
                .clickCloseJobButton()
                .clickViewInfoButton2();

        Assert.assertTrue(mainPage.checkComment().contains("Test of Martynenko Artem"), "User must leave a comment!");
    }
}
