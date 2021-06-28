package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomIntGenerator;

public class ProductPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(ProductPage.class);
    RandomIntGenerator rnd = new RandomIntGenerator();

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#add_to_cart > button")//id = "add_to_cart"
    private WebElement addToCartBtn;

    @FindBy(css = "#group_1")
    private WebElement sizes;



    public ProductItemMiniaturePage addProductToCart() {
        logger.info("random product added to card");
        click(addToCartBtn);
        return new ProductItemMiniaturePage(getDriver());
    }

//========


}
