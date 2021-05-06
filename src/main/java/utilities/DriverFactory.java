package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver getDriver() {
        WebDriver webDriver = PropertiesManager.isLocalRunMode() ? getLocalDriver() : getRemoteDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    private WebDriver getRemoteDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }

        throw new IllegalArgumentException("URL not correctly set");
    }

    private WebDriver getLocalDriver() {
        String operatingSystem = System.getProperty("os.name");
        String driverPath;
        if (operatingSystem.startsWith("Windows")) {

            driverPath = Paths.get("build", "resources",
                    "main", "drivers",
                    "windows", "geckodriver.exe").toFile().getAbsolutePath();
        } else {
            driverPath = "build/resources/main/drivers/mac/geckodriver";
        }

        System.setProperty("webdriver.gecko.driver", driverPath);
        return new FirefoxDriver();
    }
}
