package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private final WebDriver webDriver;
    private String URL = "localhost:7080/";

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return URL;
    }

    public void setUrl(String url) {
        this.URL = url;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
