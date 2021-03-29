package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    private WebElement hotSpot;

    public ContextMenuPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.setUrl(super.getUrl() + "context_menu");
    }

    public ContextMenuPage goToURL() {
        this.getWebDriver().get(this.getUrl());
        PageFactory.initElements(this.getWebDriver(), this);
        return this;
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
