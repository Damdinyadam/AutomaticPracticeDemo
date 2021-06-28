package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver;
    private EventFiringMouse eventFiringMouse;
    protected WebListener listener;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void click(WebElement element) {
        waitForElementFluent(driver, element, 40, 5);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        logger.debug("Sending text: " + text);
        waitForElementFluent(driver, element, 30, 5);
        element.clear();
        element.sendKeys(text);
    }

    public void mouseHover(WebElement element) {
        logger.info("mouseHover perform on the object: " + element.getText());
        eventFiringMouse = new EventFiringMouse(driver, listener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementFluent(WebDriver driver, WebElement element, int timeout, int timePool) {
        try {
            logger.debug("Waiting for max: " + timeout + " seconds for element to be available");
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .pollingEvery(Duration
                            .ofSeconds(timePool))
                    .withTimeout(Duration.ofSeconds(timeout))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotVisibleException.class)
                    .ignoring(StaleElementReferenceException.class);
            element = wait.until(
                    ExpectedConditions.visibilityOf(element));
            logger.debug("The item is visible on the website");
        } catch (Exception e) {
            logger.debug("The item is not visible on the website");
        }
        return element;
    }


}
