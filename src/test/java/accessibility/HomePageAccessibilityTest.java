package accessibility;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.EntryAdPage;
import pages.HomePage;

public class HomePageAccessibilityTest extends BaseTest {

    @Test
    public void accessibilityTest() {
        new HomePage(getWebDriver()).goToURL().doAccessibilityReport();
    }
}
