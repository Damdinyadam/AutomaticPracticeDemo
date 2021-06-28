package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserAccountPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(UserAccountPage.class);


    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeBtn;

    public MenuPage goBackToMainMenu() {
        logger.info("back to Main Page");
        click(homeBtn);
        return new MenuPage(getDriver());
    }


}

