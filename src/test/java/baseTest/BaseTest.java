package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public abstract class BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        webDriver = new DriverFactory().getDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
