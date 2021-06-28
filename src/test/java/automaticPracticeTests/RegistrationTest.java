package automaticPracticeTests;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MenuPage;
import providers.UserFactory;
import testBase.TestBase;


public class RegistrationTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(ShoppingTest.class);
    private MenuPage menuPage;
    private User user;

    @BeforeEach
    public void setup() {
        menuPage = new MenuPage(driver);
        user = new UserFactory().getRandomUser();
    }

    @Test
    @DisplayName("Automation practice register random user")
    public void shouldRegisterUser() {
        logger.info(">>>>>>>>>>   Start test   >>>>>>>>>>");
        logger.info("Register random User");
        menuPage.openLoginPage()
                .openRegistrationPage()
                .registerNewUser(user);


    }
}
