package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    @FindBy(css = "ul > li")
    List<WebElement> contentLinks;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getContentLinks() {
        return contentLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public HomePage goToURL() {
        getWebDriver().get(super.getUrl());
        PageFactory.initElements(getWebDriver(), this);
        return this;
    }
}
