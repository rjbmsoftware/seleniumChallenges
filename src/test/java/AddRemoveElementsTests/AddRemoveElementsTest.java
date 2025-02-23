package AddRemoveElementsTests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AddRemoveElementPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddElements() {
        int deleteButtonCount = new AddRemoveElementPage(getWebDriver())
                .goToURL()
                .clickAddElementButton()
                .clickAddElementButton()
                .getDeleteButtons()
                .size();

        assertEquals(2, deleteButtonCount);
    }
}
