import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownListTest extends BaseTest {

    @Test
    public void selectSecondOption() {
        String text = "Option 2";
        String selectedText = new DropdownPage(getWebDriver())
                .goToURL()
                .selectDropdownValue(text)
                .getDropdownSelectedValueText();

        assertEquals(text, selectedText);
    }
}
