package ImageTests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImagePresentTest extends BaseTest {

    @Test
    public void imageIsPresentTest() {
        boolean imagePresent = new BrokenImagesPage(getWebDriver()).goToURL().isExampleImagePresent(2);
        assertTrue(imagePresent);
    }
}
