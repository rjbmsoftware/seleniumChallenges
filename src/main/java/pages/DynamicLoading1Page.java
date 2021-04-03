package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading1Page extends BasePage<DynamicLoading1Page> {

    @FindBy(css = "#start > button")
    private WebElement startButton;

    @FindBy(id = "loading")
    private WebElement loadingBar;

    @FindBy(id = "finish")
    private WebElement endDisplay;

    public DynamicLoading1Page(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "dynamic_loading/1");
    }

    public DynamicLoading1Page clickStart() {
        startButton.click();
        return this;
    }

    public String getEndTextAfterLoading() {
        WebDriverWait loadingBarGone = new WebDriverWait(getWebDriver(), 10);
        loadingBarGone.until(ExpectedConditions.invisibilityOf(loadingBar));
        return endDisplay.getText();
    }
}
