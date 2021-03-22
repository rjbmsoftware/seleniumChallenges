import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

public class BaseTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.startsWith("Windows")) {
            String driverPath = Paths.get("src", "test",
                    "resources", "drivers", "windows",
                    "geckodriver.exe").toFile().getAbsolutePath();
            System.setProperty("webdriver.gecko.driver", driverPath);
        }

        webDriver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
