package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By upLoadFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String absolutePathFile) {
        driver.findElement(inputField).sendKeys(absolutePathFile);
        clickUploadButton();
    }

    public String getUploadedFiles(){
        return driver.findElement(upLoadFiles).getText();
    }
    private void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }
}
