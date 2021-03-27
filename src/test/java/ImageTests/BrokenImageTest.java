package ImageTests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BrokenImageTest extends BaseTest {

    @Test
    public void imageIsBroken() {
        boolean imagePresent = new BrokenImagesPage(getWebDriver()).goToURL().isExampleImagePresent(0);
        assertFalse(imagePresent);
    }
}
