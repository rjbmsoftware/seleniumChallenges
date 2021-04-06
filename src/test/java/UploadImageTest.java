import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.UploadPage;

import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadImageTest extends BaseTest {

    @Test
    public void uploadSuccessFileNameDisplayed() throws FileNotFoundException {
        String imageFilename = "greenPixel.png";
        URL url = ClassLoader.getSystemClassLoader().getResource(imageFilename);
        String path;

        if (url != null) {
            path = url.getPath();
        } else {
            throw new FileNotFoundException(imageFilename + " not available");
        }

        UploadPage uploadPage = new UploadPage(getWebDriver()).goToURL()
                .setUploadImagePath(path)
                .clickUploadFileButton();

        assertEquals(uploadPage.getPageHeadingText(), "File Uploaded!");
        assertEquals(uploadPage.uploadedImageNameText(), imageFilename);
    }
}
