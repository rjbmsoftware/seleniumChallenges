package checkboxes;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBoxesFlip extends BaseTest {

    @Test
    public void flippedCheckBoxesFromInitialState() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(getWebDriver()).goToURL();
        checkboxesPage.flipCheckBoxOne()
                .flipCheckBoxTwo();

        assertTrue(checkboxesPage.isCheckBoxOneChecked(), "checkbox one is not checked");
        assertFalse(checkboxesPage.isCheckBoxTwoChecked(), "checkbox two is checked");
    }
}
