package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import providers.RandomStringGenerator;

public class LoginPage extends BasePage {
    RandomStringGenerator rndString = new RandomStringGenerator();

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(css = "#email")
    private WebElement emailLogin;

    @FindBy(css = "#passwd")
    private WebElement passwordLogin;

    @FindBy(css = "#SubmitLogin")
    private WebElement signInButton;

    public RegistrationPage openRegistrationPage() {
        sendKeys(emailInput, rndString.getRandomEmail(5));
        click(createAccountBtn);
        return new RegistrationPage(getDriver());
    }

    public UserAccountPage login(User user) {
        sendKeys(emailLogin, user.getEmail());
        sendKeys(passwordLogin, user.getPassword());
        click(signInButton);
        return new UserAccountPage(getDriver());

    }

}
