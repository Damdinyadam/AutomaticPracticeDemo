package testBase;

import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;

    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    private static EnvironmentProperty environmentProperty;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Logger getLogger() {
        return logger;
    }

    @BeforeAll
    static void setUp() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialization.");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        logger.debug("implicit wait set for 20 sec");
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.debug("Driver closed.");
        logger.info(">>>>>>>>>>   End test   >>>>>>>>>>");
    }
}
