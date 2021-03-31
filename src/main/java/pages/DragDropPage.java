package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragDropPage extends BasePage<DragDropPage> {

    @FindBy(id = "column-a")
    WebElement boxA;

    @FindBy(id = "column-b")
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
        Actions action = new Actions(getWebDriver());
        action.clickAndHold(boxA)
                .moveToElement(boxB)
                .release(boxA)
                .build()
                .perform();

        return this;
    }
}
