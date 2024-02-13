package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAutentication();

        loginPage.setUserName("tomsmith");
        loginPage.setPasssword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");

    }
}
