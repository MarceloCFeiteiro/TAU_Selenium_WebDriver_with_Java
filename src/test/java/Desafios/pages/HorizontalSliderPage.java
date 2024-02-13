package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;

    private By sliderType = By.cssSelector("input[type]");

    private By sliderContainer = By.cssSelector(".sliderContainer span");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSlider(String amount) {
        while (!getSliderValue().equals(amount)) {
            driver.findElement(sliderType).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderContainer).getText();
    }
}
