package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.page.HomePage;
import ui.page.MainPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        MainPage mainPage = new HomePage(driver).goToLoginPage()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickProfile();

        Assert.assertTrue(mainPage.checkButtonLogout().contains("Logout"), "User should be logged in!");
    }
}