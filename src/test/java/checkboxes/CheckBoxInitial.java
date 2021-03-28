package checkboxes;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBoxInitial extends BaseTest {

    @Test
    public void checkBoxOneNotCheckedCheckBoxTwoCheckedTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(getWebDriver()).goToURL();

        boolean isCheckBoxOneChecked = checkboxesPage.isCheckBoxOneChecked();
        assertFalse(isCheckBoxOneChecked, "checkbox one is checked");


        boolean isCheckBoxTwoChecked = checkboxesPage.isCheckBoxTwoChecked();
        assertTrue(isCheckBoxTwoChecked, "checkbox two is not checked");
    }
}
