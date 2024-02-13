package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class AlertTest extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();

        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();

        assertEquals(alertPage.getResult(), "You successfully clicked an alert", "Result test incorrect");
    }

    @Test
    public void testGetTestFromAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();

        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToDismiss();

        assertEquals(text, "I am a JS Confirm", "Result test incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();

        alertPage.triggerPrompt();
        String text = "TAU rocks";
        alertPage.alert_setInput("TAU rocks");
        alertPage.alert_clickToAccept();

        assertEquals(alertPage.getResult(), "You entered: " + text, "Result test incorrect");
    }
}
