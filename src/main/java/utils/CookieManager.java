package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {
    private WebDriver driver;

    public CookieManager(WebDriver driver){
        this.driver = driver;
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }

    public boolean isCookiePresent(Cookie cookie){
        System.out.println(cookie.getName());
        System.out.println(driver.manage().getCookieNamed(cookie.getName()) != null);

        System.out.println(driver.manage().getCookieNamed(cookie.getName()));
        return driver.manage().getCookieNamed(cookie.getName()) != null;
    }

    public Cookie buildCookie(String name, String value){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain("the-internet.herokuapp.com")
                .build();
        return cookie;
    }
}
