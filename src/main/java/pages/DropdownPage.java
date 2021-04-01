package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage<DropdownPage> {

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "dropdown");
    }

    public DropdownPage selectDropdownValue(String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
        return this;
    }

    public String getDropdownSelectedValueText() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
}
