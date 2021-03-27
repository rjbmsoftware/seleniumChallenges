package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    @FindBy(css = "div.example > img")
    List<WebElement> images;

    public BrokenImagesPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "broken_images");
    }

    public BrokenImagesPage goToURL() {
        getWebDriver().get(getUrl());
        PageFactory.initElements(getWebDriver(), this);
        return this;
    }

    public boolean isExampleImagePresent(int index) {
        return !images.get(index).getAttribute("naturalWidth").equals("0");
    }
}
