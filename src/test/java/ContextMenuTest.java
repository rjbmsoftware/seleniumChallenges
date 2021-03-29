import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuSelectedDisplaysModel() {
        boolean modalDisplayed = new ContextMenuPage(getWebDriver()).goToURL()
                .selectContextMenuInRectangle()
                .isContextModalDisplayed();

        assertTrue(modalDisplayed);
    }
}
