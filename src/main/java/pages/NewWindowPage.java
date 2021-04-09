package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPage extends BasePage<NewWindowPage> {

    public static final String PAGE_TITLE = "New Window";

    @FindBy(css = "div.example > h3")
    WebElement heading;

    public NewWindowPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public String getHeadingText() {
        return heading.getText();
    }
}
