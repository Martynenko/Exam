package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.page.HomePage;
import ui.page.ProfilePage;

public class CreateJobTest extends BaseTest {
    @Test
    public void createJobTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        ProfilePage profilePage = new HomePage(driver).goToLoginPage()
                .setUsername("artem.martynenko@privatbank.ua")
                .setPassword("qwerty123456")
                .clickLoginButton()
                .clickProfile()
                .clickProfileButton()
                .clickAddJobButton()
                .setTitle("QA")
                .setDescription("Testing software")
                .setPrice("15000")
                .clickCreateJobButton()
                .clickCloseProfileButton();

                Assert.assertTrue(profilePage.checkTextTitle().contains("QA"), "The field Title was not filled!");
                Assert.assertTrue(profilePage.checkTextDescription().contains("Testing software"), "The field Description was not filled!");
                Assert.assertTrue(profilePage.checkTextPrice().contains("15000"), "The field Price was not filled!");
    }
}