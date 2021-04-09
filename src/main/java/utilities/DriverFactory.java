package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver getDriver() {
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


        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return webDriver;
    }
}
