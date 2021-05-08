package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
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

    public void doAccessibilityReport() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        InputStream inputStream = getClass().getResourceAsStream("javaScript/axe.min.js");

        try {
            assert inputStream != null;
            String content = new String(inputStream.readAllBytes());
            javascriptExecutor.executeAsyncScript(content);

            File output = new File("path/to/report.json");
//            FileWriter writer = new FileWriter(output);
            String result = String.valueOf(javascriptExecutor.executeAsyncScript("var callback = arguments[arguments.length - 1]; axe.run().then(results => callback(results));"));
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
