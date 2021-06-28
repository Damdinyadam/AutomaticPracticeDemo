package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(AddressPage.class);

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn.btn-default.button-medium")
    private WebElement addressPageProceedToCheckOutBtn;

    public ShippingPage addressPageProceedToCheckOut() {
        logger.info("clicked proceed to checkout on adress Page");
        click(addressPageProceedToCheckOutBtn);
        return new ShippingPage(getDriver());
    }
}
