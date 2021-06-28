package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderSummaryPage extends BasePage{
    private static Logger logger = LoggerFactory.getLogger(OrderSummaryPage.class);

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "button.btn.btn-default.button-medium")
    private WebElement confirmOrderBtn;

    public OrderFinallyPage confirmMyOrder() {
        logger.info(">>>proceed to confirm the order <<<");
        click(confirmOrderBtn);
        return new OrderFinallyPage(getDriver()) ;   }


}
