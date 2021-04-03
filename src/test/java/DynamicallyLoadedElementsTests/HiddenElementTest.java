package DynamicallyLoadedElementsTests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.DynamicLoading1Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HiddenElementTest extends BaseTest {

    @Test
    public void waitingForHelloWorldTest() {
        String endText = new DynamicLoading1Page(getWebDriver())
                .goToURL()
                .clickStart()
                .getEndTextAfterLoading();

        assertEquals("Hello World!", endText);
    }
}
