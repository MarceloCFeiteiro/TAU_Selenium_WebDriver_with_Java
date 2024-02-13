package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userNameField = By.id("username");

    private By passswordField = By.id("password");

    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void setUserName(String name){
        driver.findElement(userNameField).sendKeys(name);
    }

    public  void setPasssword(String passsword){
        driver.findElement(passswordField).sendKeys(passsword);
    }

    public  SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}

