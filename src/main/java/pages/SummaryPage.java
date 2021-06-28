package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SummaryPage extends BasePage {


    private static Logger logger = LoggerFactory.getLogger(SummaryPage.class);
    public SummaryPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "button btn btn-default")
//    @FindBy(css = "div#center_column  a[title='Proceed to checkout'] > span")
    @FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium")
    private WebElement summaryPageProceedToCheckOutBtn;

    public AddressPage summaryPageProceedToCheckOut() {
        logger.info("clicked proceed to checkout on summary Page");
        click(summaryPageProceedToCheckOutBtn);
        return new AddressPage(getDriver());
    }

}
