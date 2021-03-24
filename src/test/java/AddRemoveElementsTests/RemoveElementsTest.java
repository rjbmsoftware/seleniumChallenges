package AddRemoveElementsTests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AddRemoveElementPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementsTest extends BaseTest {

    @Test
    public void removeDeleteButton() {
        int deleteButtonCount = new AddRemoveElementPage(getWebDriver())
                .goToURL()
                .clickAddElementButton()
                .clickAddElementButton()
                .clickDeleteButton()
                .getDeleteButtons()
                .size();

        assertEquals(1, deleteButtonCount);
    }
}
