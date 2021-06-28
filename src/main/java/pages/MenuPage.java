package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomIntGenerator;

import java.util.List;


public class MenuPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(MenuPage.class);
    RandomIntGenerator rnd = new RandomIntGenerator();
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.login")
    private WebElement signInBtn;

    public LoginPage openLoginPage() {
        click(signInBtn);
        return new LoginPage(getDriver());
    }

    @FindBy(css = "#homefeatured.product_list>li")
    private List<WebElement> allProducts;


    public ProductPage openProductPage() {
        logger.info(">> random product automatically choosed");
        click(allProducts.get(rnd.generateRandomIndex(allProducts.size())));
        return new ProductPage(getDriver());
    }


}
