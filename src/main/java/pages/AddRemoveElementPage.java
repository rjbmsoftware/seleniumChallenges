package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AddRemoveElementPage extends BasePage {

    public String URL = super.getUrl() + "add_remove_elements/";

    @FindBy(css = "div.example > button")
    private WebElement addElementButton;

    @FindBy(css = "#elements > button")
    private List<WebElement> deleteButtons;

    public AddRemoveElementPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public AddRemoveElementPage clickAddElementButton() {
        addElementButton.click();
        return this;
    }

    public List<String> getDeleteButtons() {
        return deleteButtons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public AddRemoveElementPage goToURL() {
        getWebDriver().get(URL);
        return this;
    }

    public AddRemoveElementPage clickDeleteButton() {
        deleteButtons.get(0).click();
        return this;
    }
}
