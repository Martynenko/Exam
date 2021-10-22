package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.page.HomePage;
import ui.page.ProfilePage;

public class RemoveJobTest extends BaseTest {

    @Test
    public void removeJobTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        ProfilePage profilePage = new HomePage(driver).goToLoginPage()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickProfile()
                .clickProfileButton()
                .clickRemoveButton();

        Assert.assertTrue(profilePage.checkTitle().contains("QA"), "The field Title does not filled!");
        Assert.assertTrue(profilePage.checkComments().contains("Comments: 0"), "The field Comments does not filled!");
        Assert.assertTrue(profilePage.checkPrice().contains("15000"), "The field Price does not filled!");
        Assert.assertTrue(profilePage.checkDescription().contains("Testing software"), "The field Description does not filled!");

    }
}