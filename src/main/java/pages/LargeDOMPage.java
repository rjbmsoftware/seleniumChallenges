package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LargeDOMPage extends BasePage<LargeDOMPage> {

    @FindBy(id = "large-table")
    WebElement largeTable;

    public LargeDOMPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "large");
    }

    public LargeDOMPage scrollToLargeTable() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        Point position = largeTable.getLocation();
        String script = "scrollTo(arguments[0], arguments[1])";
        javascriptExecutor.executeScript(script, position.getX(), position.getY());
        return this;
    }

    public boolean isLargeTableVisible() {
        return largeTable.isDisplayed();
    }
}
