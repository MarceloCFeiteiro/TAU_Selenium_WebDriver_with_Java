package Desafios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;

    private String frameTop = "frame-top";

    private String frameLeft = "frame-left";

    private String frameBotton = "frame-bottom";

    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameText() {
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame(frameLeft);

        String text = getTextFame();

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        return text;
    }

    public String getBottomFrameText() {
        driver.switchTo().frame(frameBotton);

        String text = getTextFame();

        driver.switchTo().parentFrame();

        return text;
    }

    private String getTextFame() {
        return driver.findElement(body).getText();
    }
}
