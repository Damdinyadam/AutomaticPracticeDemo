package automaticPracticeTests;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;
import providers.UserFactory;
import testBase.TestBase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShoppingTest extends TestBase {

    private static Logger logger = LoggerFactory.getLogger(ShoppingTest.class);
    private MenuPage menuPage;

    private OrderFinallyPage orderfinallyPage;
    private User user;

    @BeforeEach
    public void setup() {
        menuPage = new MenuPage(driver);
        orderfinallyPage = new OrderFinallyPage(driver);
        user = new UserFactory().getAlreadyRegisteredUser();

    }

    @Test
    @DisplayName("Automation practice- buy product")
    public void shouldBuyRandomProduct()  {
        logger.info(">>>>>>>>>>   Start test   >>>>>>>>>>");
        logger.info("Login existing User & buy random product");

        menuPage.openLoginPage()
                .login(user)
                .goBackToMainMenu()
                .openProductPage()
                .addProductToCart()
                .productItemProceedToCheckout()
                .summaryPageProceedToCheckOut()
                .addressPageProceedToCheckOut()
                .termsCondition()
                .shippingPageProceedToCheckOut()
                .payByCheck()
                .confirmMyOrder();

//Przeniesć do summary page
        String orderStatus =orderfinallyPage.getOrderCompleteText();
        String expectedOrderStatus = System.getProperty("orderStatus");
        assertThat(orderStatus, equalTo(expectedOrderStatus));
        logger.info("orderStatus=Your order on My Store is complete.");

    }

}
