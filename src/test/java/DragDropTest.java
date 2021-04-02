import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.DragDropPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragDropTest extends BaseTest {

    @Test
    public void dragAtoB() {
        DragDropPage dragDropPage = new DragDropPage(getWebDriver()).goToURL().dragAToB();

        assertEquals("A", dragDropPage.getBoxBText());
        assertEquals("B", dragDropPage.getBoxAText());
    }
}
