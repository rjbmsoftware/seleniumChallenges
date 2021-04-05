import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.EntryAdPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntryAdTest extends BaseTest {

    @Test
    public void entryAdDisplayedThenDismissedTest() {
        EntryAdPage entryAdPage = new EntryAdPage(getWebDriver());

        String modalText = entryAdPage.goToURL().getModalText();
        entryAdPage.closeModal();
        String pageHeader = entryAdPage.getPageHeaderText();

        String expectedModalText = "It's commonly used to encourage a user to take an action";
        assertTrue(modalText.startsWith(expectedModalText));
        assertEquals("Entry Ad", pageHeader);
    }
}
