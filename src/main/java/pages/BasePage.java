package pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private static final String URL = "http://localhost:7080/";
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static String getUrl() {
        return URL;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
