package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage<BasicAuthPage> {
    public final String endPath = "basic_auth/";
    public final String URL = super.getUrl() + endPath;

    @FindBy(css = "div.example > p")
    WebElement authTextElement;

    public BasicAuthPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Logs in user to page implemented in this way due to removed support for auth prompts
     * https://github.com/w3c/webdriver/issues/385
     * @param username username
     * @param password password
     * @return logged in page
     */
    public BasicAuthPage goToURL(String username, String password) {
        String prefix = username + ":" + password + "@";
        String newUrl = prefix + this.URL;

        return this.setUrl(newUrl).goToURL();
    }

    public boolean isLoggedIn() {
        return authTextElement.getText().startsWith("Congratulations!");
    }
}
