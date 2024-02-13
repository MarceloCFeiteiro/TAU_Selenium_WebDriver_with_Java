package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;

    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickInHotSpotWithRightMouseButton(){
        Actions action = new Actions(this.driver);

        var boxHotSpot = driver.findElement(hotSpot);

        action.contextClick(boxHotSpot).perform();
    }

    public String getTextOfAlert(){
        return driver.switchTo().alert().getText();
    }
}
