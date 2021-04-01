package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage<ContextMenuPage> {

    @FindBy(id = "hot-spot")
    private WebElement hotSpot;

    public ContextMenuPage(WebDriver webDriver) {
        super(webDriver);
        this.setUrl(super.getUrl() + "context_menu");
    }

    public boolean isContextModalDisplayed() {
        String text = getWebDriver().switchTo().alert().getText();
        return text != null;
    }

    public ContextMenuPage selectContextMenuInRectangle() {
        Actions action = new Actions(getWebDriver());
        action.contextClick(hotSpot).build().perform();
        return this;
    }
}
