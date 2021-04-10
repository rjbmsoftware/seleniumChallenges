import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.UploadPage;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadImageTest extends BaseTest {

    @Test
    public void uploadSuccessFileNameDisplayed() throws URISyntaxException {
        String imageFilename = "greenPixel.png";
        URI uri = Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                .getResource(imageFilename))
                .toURI();
        String path = Path.of(uri).toString();

        UploadPage uploadPage = new UploadPage(getWebDriver()).goToURL()
                .setUploadImagePath(path)
                .clickUploadFileButton();

        assertEquals(uploadPage.getPageHeadingText(), "File Uploaded!");
        assertEquals(uploadPage.uploadedImageNameText(), imageFilename);
    }
}
