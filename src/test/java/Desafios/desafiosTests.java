package Desafios;


import Desafios.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.CookieManager;
import utils.WindowManager;

import java.util.List;

import static org.testng.Assert.*;

public class desafiosTests {
    private WebDriver driver;

    @Test
    public void desafioChapter3() {
        navegarParaHomePage();

        WebElement shifting = driver.findElement(By.linkText("Shifting Content"));
        shifting.click();

        WebElement exemple = driver.findElement(By.linkText("Example 1: Menu Element"));
        exemple.click();

        List<WebElement> menus = driver.findElements(By.cssSelector("ul>li"));
        System.out.println(menus.size());

        System.out.println(driver.getTitle());
        driver.quit();

    }

    @Test
    public void desafioChapter4() {
        navegarParaHomePage();

        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password"));
        forgotPassword.click();

        var forgotEmailSent = new ForgotPasswordPage(driver);

        forgotEmailSent.setEmail("Tau@example.com");
        var emailSentPage = forgotEmailSent.clickRetrivePassordButton();

        assertTrue(emailSentPage.getAlertText().contains("Your e-mail's been sent!"), "Alert text is incorrect");
        driver.quit();
    }

    @Test
    public void desafioChapter6() {
        navegarParaHomePage();

        WebElement horizontalSlider = driver.findElement(By.linkText("Horizontal Slider"));
        horizontalSlider.click();

        var horizontalSliderPage = new HorizontalSliderPage(driver);

        horizontalSliderPage.setSlider("4");
        driver.quit();
    }

    @Test
    public void desafioChapter7() {
        navegarParaHomePage();

        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();

        var contextMenuPage = new ContextMenuPage(driver);

        contextMenuPage.clickInHotSpotWithRightMouseButton();

        assertTrue(contextMenuPage.getTextOfAlert().contains("You selected a context menu"), "Alert text is incorrect");

        driver.quit();
    }

    @Test
    public void desafioChapte8() {
        navegarParaHomePage();

        WebElement frames = driver.findElement(By.linkText("Frames"));
        frames.click();

        var framePage = new FramePage(driver);

        var nestedFramesPage = framePage.clickNestedFrames();

        assertTrue(nestedFramesPage.getLeftFrameText().contains("LEFT"), "Frame text is incorrect");
        assertTrue(nestedFramesPage.getBottomFrameText().contains("BOTTOM"), "Frame text is incorrect");

        driver.quit();
    }

    @Test
    public void desafioChapte9() {
        navegarParaHomePage();

        WebElement waitings = driver.findElement(By.linkText("Dynamic Loading"));
        waitings.click();

        var dynamicLoadingPage = new DynamicLoadingPage(driver);

        var dynamicLoadingExample2Page = dynamicLoadingPage.clickExample2();

        dynamicLoadingExample2Page.clickStart();

        assertTrue(dynamicLoadingExample2Page.getLoadText().contains("Hello World!"), "Waiting text is incorrect");

        driver.quit();
    }

    @Test
    public void desafioChapte10() {
        navegarParaHomePage();

        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));
        dropdown.click();

        var dropDownPage = new DropdownPage(driver);

        dropDownPage.addMultipleAtributte();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");

        driver.quit();
    }

    @Test
    public void desafioChapte11Example2() {
        navegarParaHomePage();

        WebElement dynamicLoading = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoading.click();

        var dynamicLoadingPage = new DynamicLoadingPage(driver);

        var dynamicLoadingExample2 = dynamicLoadingPage.rightClickOnExample2Link();

        var windowsMannager = new WindowManager(driver);
        windowsMannager.switchToNewTab();

        assertTrue(dynamicLoadingExample2.isStartButtonDisplayed(), "Start button is not displayed");

        driver.quit();
    }

    @Test
    public void desafioChapte14() {
        navegarParaHomePage();

        var cookieManager = new CookieManager(driver);

        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%7D");

        cookieManager.deleteCookie(cookie);

        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");

        driver.quit();
    }

    private void navegarParaHomePage() {
        System.setProperty("wedriver.chorme.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(375,812));//Usado para simular uma dispositivo
    }
}
