package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.page.HomePage;
import ui.page.MainPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        MainPage mainPage = new HomePage(driver).goToRegistrationPage()
                .setRegistrationUsername("artem.martynenko@privatbank.ua")
                .setRegistrationName("Artem")
                .setRegistrationLastname("Martynenko")
                .setRegistrationPassword("qwerty123456")
                .setConfirmRegistrationPassword("qwerty123456")
                .clickRegistrationButton()
                .clickSigninButton()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickProfile();

        Assert.assertTrue(mainPage.checkButtonLogout().contains("Logout"), "User should be logged in!");
    }
}
