package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    private WebDriver driver;
    private By StatusAlert = By.id("flash");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(StatusAlert).getText();
    }
}
