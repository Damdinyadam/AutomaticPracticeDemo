package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShippingPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(ShippingPage.class);
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn.btn-default.standard-checkout.button-medium")
    private WebElement shippingPageProceedToCheckOutBtn;

    @FindBy(id = "uniform-cgv")
//    @FindBy(id = "cgv")
//    @FindBy(css="#uniform-cgv")
//    @FindBy(css = "#cgv")
//    @FindBy(css = "#form > div > p.checkbox")
//    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement termsOfServiceCbx;

    public ShippingPage termsCondition(){
        logger.info(">>> accept terms and conditions <<<<<<<");
        click(termsOfServiceCbx);
        return this;
    }

    public PaymentPage shippingPageProceedToCheckOut() {
        logger.info("clicked proceed to checkout on shippingPage");
        click(shippingPageProceedToCheckOutBtn);
        return new PaymentPage(getDriver());
    }
}
