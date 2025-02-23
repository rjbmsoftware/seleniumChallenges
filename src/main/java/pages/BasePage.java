package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.PropertiesManager;

public abstract class BasePage<T> {

    private final WebDriver webDriver;
    private String URL = PropertiesManager.getURL();

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return URL;
    }

    public T setUrl(String url) {
        this.URL = url;
        return (T) this;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public T goToURL() {
        this.getWebDriver().get(this.getUrl());
        PageFactory.initElements(this.getWebDriver(), this);

        return (T) this;
    }
}
