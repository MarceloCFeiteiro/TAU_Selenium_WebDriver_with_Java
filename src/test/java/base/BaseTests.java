package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private EventFiringWebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("wedriver.chorme.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //  driver.manage().timeouts().pageLoadTimeout();espara as páginas dos projetos carregarem
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        setCookie();
        //driver.manage().window().setSize(new Dimension(375,812));//Usado para simular uma dispositivo
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void Teardown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

            var camera = (TakesScreenshot) driver;
            var screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + "png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BaseTests tests = new BaseTests();
        tests.setUp();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(this.driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.addArguments("--headless=new");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
 }
}
