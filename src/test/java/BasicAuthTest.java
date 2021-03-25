import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BasicAuthPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthTest extends BaseTest {

    @Test
    public void successfulLogin() {
        String userPass = "admin";
        boolean isLoggedIn = new BasicAuthPage(getWebDriver())
                .goToURL(userPass, userPass)
                .isLoggedIn();

        assertTrue(isLoggedIn);
    }
}
