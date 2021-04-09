import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.OpensNewWindowPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageOpensNewTabTest extends BaseTest {

    @Test
    public void opensNewTabTest() {
        String headingText = new OpensNewWindowPage(getWebDriver())
                .goToURL()
                .clickNewPageLink()
                .getHeadingText();

        assertEquals("New Window", headingText);
    }
}
