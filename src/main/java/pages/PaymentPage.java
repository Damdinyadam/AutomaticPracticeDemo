package pages;

import models.PaymentOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = ".bankwire")
    private WebElement payByWire;

//    @FindBy(className = ".cheque")
    @FindBy(css = ".cheque")
    private WebElement payByCheck;

//    public OrderSummaryPage paymentsOptionSelector() {
//        logger.info(">>>>>>> choose method of payment <<<<<<<");
//        if (PaymentOptions.getSelectedPaymentOptions().equals(PaymentOptions.payByBankWire)) {
//            logger.info(" pay by bank wire method choosen ");
//            click( payByWire);
//        } else {
//            logger.info("pay by bank check method choosen ");
//            click(payByCheck);
//        }
//        return new OrderSummaryPage(getDriver());
//    }
public OrderSummaryPage payByCheck() {
    click(payByCheck);
    return new OrderSummaryPage(getDriver());
}


}
