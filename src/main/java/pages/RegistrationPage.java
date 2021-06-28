package pages;

import models.Gender;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "id_gender1")
    private WebElement maleRBtn;

    @FindBy(id  = "id_gender2")
    WebElement femaleRBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(css = "#days")
    private WebElement days;

    @FindBy(css = "#months")
    private WebElement months;

    @FindBy(css = "#years")
    private WebElement years;

    @FindBy(css = "#company")
    private WebElement companyFld;

    @FindBy(css = "#address1")
    private WebElement addrStreetInput;

    @FindBy(css = "#city")
    private WebElement addrCityInput;

    @FindBy(css = "#id_state")
    private WebElement  addrStateSelect;

    @FindBy(css = "#postcode")
    private WebElement addrPostalCodeInput;

    @FindBy(css = "#id_country")
    private WebElement addrCountrySelect;

    @FindBy(css = "#phone_mobile")
    private WebElement addrPhoneInput;

    @FindBy(css = "#alias")
    private WebElement addrAliasInput;

    @FindBy(css = "#submitAccount")
    private WebElement registerBtn;


    public void registerNewUser(User user) {
        sendKeys(firstNameInput, user.getFirstName());
        sendKeys(lastNameInput, user.getLastName());
        sendKeys(passwordInput, user.getPassword());
        sendKeys(addrStreetInput, user.getStreet());
        sendKeys(addrCityInput, user.getCity());
        selectElement(addrStateSelect, user.getState());
        sendKeys(addrPostalCodeInput, user.getPostalCode());
        selectElement(addrCountrySelect, user.getCountry());
        sendKeys(addrPhoneInput, user.getPhone());
        sendKeys(addrAliasInput, user.getAlias());
        if (user.getGender() == Gender.FEMALE) {
            click(femaleRBtn);
        } else {
            click(maleRBtn);
        }
        click(registerBtn);
    }

    private void selectElement(WebElement addrCountrySelect, String country) {
    }

}
