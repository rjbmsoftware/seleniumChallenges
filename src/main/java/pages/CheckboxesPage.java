package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends BasePage<CheckboxesPage> {

    @FindBy(xpath = ".//form/input[1]")
    WebElement checkBoxOne;

    @FindBy(xpath = "//form/input[2]")
    WebElement checkBoxTwo;

    public CheckboxesPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "checkboxes");
        PageFactory.initElements(webDriver, this);
    }

    public CheckboxesPage flipCheckBoxOne() {
        checkBoxOne.click();
        return this;
    }

    public CheckboxesPage flipCheckBoxTwo() {
        checkBoxTwo.click();
        return this;
    }

    public boolean isCheckBoxOneChecked() {
        return checkBoxOne.isSelected();
    }

    public boolean isCheckBoxTwoChecked() {
        return checkBoxTwo.isSelected();
    }
}
