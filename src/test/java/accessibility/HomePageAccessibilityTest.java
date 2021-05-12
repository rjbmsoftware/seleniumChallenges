package accessibility;

import baseTest.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageAccessibilityTest extends BaseTest {

    @Disabled
    @Test
    public void accessibilityTest() throws IOException {
        int numberOfAccessibilityViolations = new HomePage(getWebDriver())
                .goToURL()
                .accessibilityViolations();
        assertEquals(0, numberOfAccessibilityViolations);
    }
}
