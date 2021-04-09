package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class OpensNewWindowPage extends BasePage<OpensNewWindowPage> {

    @FindBy(css = "div.example > a")
    WebElement newWindowLink;

    public OpensNewWindowPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "windows");
    }

    public NewWindowPage clickNewPageLink() {
        newWindowLink.click();
        Set<String> browserHandles = getWebDriver().getWindowHandles();
        for (String handle : browserHandles) {
            getWebDriver().switchTo().window(handle);
            if (getWebDriver().getTitle().contains(NewWindowPage.PAGE_TITLE)) {
                break;
            }
        }

        return new NewWindowPage(getWebDriver());
    }
}
