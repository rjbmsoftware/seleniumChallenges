package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage<HomePage> {
    @FindBy(css = "ul > li")
    List<WebElement> contentLinks;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getContentLinks() {
        return contentLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int accessibilityViolations() throws IOException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("javaScript/axe.min.js");

        assert inputStream != null;
        String axeJsScript = new String(inputStream.readAllBytes());
        javascriptExecutor.executeScript(axeJsScript);

        String numberOfViolations = String.valueOf(javascriptExecutor.executeAsyncScript(
                "var callback = arguments[arguments.length - 1]; " +
                        "axe.run().then(results => callback(results.violations.length));"
        ));

        return Integer.parseInt(numberOfViolations);
    }
}
