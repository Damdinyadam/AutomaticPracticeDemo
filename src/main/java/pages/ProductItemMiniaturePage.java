package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductItemMiniaturePage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(ProductItemMiniaturePage.class);
    public ProductItemMiniaturePage(WebDriver driver) {
        super(driver);
    }



//    @FindBy(css = ".btn.btn-default.button.button-medium")
//    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    @FindBy(css = "[title='Proceed to checkout']")
    private WebElement ProductItemMiniaturePageProceedToCheckoutBtn;



    public SummaryPage productItemProceedToCheckout() {
        logger.info("clicked proceed to checkout btn in miniature page");
        click(ProductItemMiniaturePageProceedToCheckoutBtn);
        return new SummaryPage(getDriver());
    }


}
