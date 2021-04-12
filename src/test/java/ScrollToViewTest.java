import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LargeDOMPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrollToViewTest extends BaseTest {

    @Test
    public void scrollToViewTable() {
        boolean tableDisplayed = new LargeDOMPage(getWebDriver())
                .goToURL()
                .scrollToLargeTable()
                .isLargeTableVisible();
        assertTrue(tableDisplayed, "large table is not displayed");
    }
}
