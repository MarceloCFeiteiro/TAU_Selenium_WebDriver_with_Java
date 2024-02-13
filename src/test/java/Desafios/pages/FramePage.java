package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
    private WebDriver driver;

    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFrames(){
        driver.findElement(By.linkText("Nested Frames")).click();
        return new NestedFramesPage(driver);
    }
}
