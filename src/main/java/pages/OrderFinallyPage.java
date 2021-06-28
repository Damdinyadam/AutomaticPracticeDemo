package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OrderFinallyPage extends BasePage{
    private static Logger logger = LoggerFactory.getLogger(OrderFinallyPage.class);
    public OrderFinallyPage(WebDriver driver) {
        super(driver);
    }


//    @FindBy(css="#center_column > div > p > strong")
//    @FindBy(css = ".alert.alert-success")
    @FindBy(css = "#center_column > p.alert.alert-success")
//    @FindBy(css=".cheque-indent")
    private WebElement orderCompleteText;


    public String getOrderCompleteText() {
        waitForElementFluent(getDriver(), orderCompleteText, 30,5);
      return orderCompleteText.getText();
    }
}
