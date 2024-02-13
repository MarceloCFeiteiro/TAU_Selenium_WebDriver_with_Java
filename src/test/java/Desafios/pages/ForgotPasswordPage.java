package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SecureAreaPage;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By passswordField = By.id("email");
    private By loginButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void setEmail(String passsword){
        driver.findElement(passswordField).sendKeys(passsword);
    }

    public EmailSentPage clickRetrivePassordButton(){
        driver.findElement(loginButton).click();
        return new EmailSentPage(driver);
    }
}
