package accessibility;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.EntryAdPage;
import pages.HomePage;

public class HomePageAccessibilityTest extends BaseTest {

    @Test
    public void accessibilityTest() {

//        HomePage homePage = new HomePage(getWebDriver());
//        homePage.goToURL();
        new HomePage(getWebDriver()).goToURL().doAccessibilityReport();
    }
}
