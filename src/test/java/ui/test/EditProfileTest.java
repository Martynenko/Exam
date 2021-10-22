package ui.test;

import ui.base.BaseTest;
import ui.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.page.ProfilePage;

public class EditProfileTest extends BaseTest {

    @Test
    public void editProfileTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        ProfilePage profilePage = new HomePage(driver).goToLoginPage()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickProfile()
                .clickProfileButton()
                .clickEditInfoButton()
                .clearFieldName()
                .setName("Artem")
                .clearFieldLastame()
                .setLastname("Martynenko")
                .clickUpdateButton();

        Assert.assertTrue(profilePage.checkUserdata().contains("Artem Martynenko"), "User data has not been updated!");

    }
}
