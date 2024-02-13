package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {

    private WebDriver driver;

    private By startButton = By.cssSelector("#start button");

    private By loadingIndicator = By.id("loading");

    private By loadText = By.id("finish");

    private WebDriverWait wait;

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }

    public String getLoadText() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadText)));
        return driver.findElement(loadText).getText();
    }
}
