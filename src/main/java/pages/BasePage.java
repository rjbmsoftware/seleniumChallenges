package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public final String URL = "http://localhost:7080/";
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return URL;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
