import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BaseTest {
    @Test
    public void homePageLoadedTest() {
        int linkCount = new HomePage(getWebDriver()).goToURL().getContentLinks().size();
        assertEquals(44, linkCount);
    }
}
