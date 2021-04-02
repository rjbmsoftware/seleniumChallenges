package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DragDropHTML5;

public class DragDropPage extends BasePage<DragDropPage> {
    private final String boxAId = "#column-a";
    private final String boxBId = "#column-b";

    @FindBy(css = boxAId)
    WebElement boxA;

    @FindBy(css = boxBId)
    WebElement boxB;

    public DragDropPage(WebDriver webDriver) {
        super(webDriver);
        this.setUrl(getUrl() + "drag_and_drop");
    }

    public String getBoxAText() {
        return boxA.getText();
    }

    public String getBoxBText() {
        return boxB.getText();
    }

    public DragDropPage dragAToB() {
        DragDropHTML5.dragAndDrop(getWebDriver(), boxAId, boxBId);
        return this;
    }
}
