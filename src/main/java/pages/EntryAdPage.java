package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage extends BasePage<EntryAdPage> {

    @FindBy(css = "div.modal-body")
    WebElement modalText;

    @FindBy(css = "div.modal-footer > p")
    WebElement modalClose;

    @FindBy(css = "h3")
    WebElement entryAdPageHeader;

    public EntryAdPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "entry_ad");
    }

    @Override
    public EntryAdPage goToURL() {
        super.goToURL();
        waitForModalToDisplay(this.getWebDriver());
        return this;
    }

    private void waitForModalToDisplay(WebDriver webDriver) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10L);
        webDriverWait.until(ExpectedConditions.visibilityOf(modalText));
    }

    public String getModalText() {
        return modalText.getText();
    }

    public EntryAdPage closeModal() {
        modalClose.click();
        return this;
    }

    public String getPageHeaderText() {
        return entryAdPageHeader.getText();
    }
}
