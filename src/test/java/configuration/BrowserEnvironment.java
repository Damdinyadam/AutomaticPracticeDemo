package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WebListener;


//klasa typu helper
public class BrowserEnvironment {
    //defaultowa konfiguracja, dane, jesli nie ma zdefiniowanych
    // zmiennych dla konkretnego srodowiska to bedzie tych używał
    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private int webBrowserExplicitClick;
    private boolean attachScreenShot;
    private Logger logger;
    private WebDriver webDriver;//glowny
    WebListener webListener;
    private EventFiringWebDriver driver;

    //konstruktor
    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitTimeOut = 5;
        this.attachScreenShot = true;
        logger = LoggerFactory.getLogger("BrowserEnvironment.class");
        //bedzie brany z klasy ktora najpierw musi spr czy jest to zdefiniowane  w pliku
        //BROWSER będzie enumem
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getValue() : this.browserName;
        this.initBrowserSettings(); //metoda
    }

    private void initBrowserSettings() {
        this.webElementTimeOut = PropertyStore.BROWSER_EXPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_EXPLICIT_TIMEOUT.getIntValue() : this.webElementTimeOut;
        this.webBrowserImplicitTimeOut = PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
        this.attachScreenShot = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
        this.headlessBrowser = PropertyStore.BROWSER_HEADLESS.getBoolean();
        this.webBrowserExplicitClick = PropertyStore.BROWSER_EXPLICIT_CLICK.isSpecified() ? PropertyStore.BROWSER_EXPLICIT_CLICK.getIntValue() : this.webBrowserExplicitClick;
    }

    public WebDriver getDriver() {
       EventFiringWebDriver driver;//lokalny

        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                webDriver = new ChromeDriver(optionsChrome);
                driver= new EventFiringWebDriver(webDriver);
                webListener=new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                webDriver = new FirefoxDriver(optionsFirefox);
                driver= new EventFiringWebDriver(webDriver);
                webListener=new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsdefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver(optionsdefault);
                driver= new EventFiringWebDriver(webDriver);
                webListener=new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
        }
//do tego glownego przypisuje lokalny
        this.driver = driver;
        return this.driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }

    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }

    public void setWebBrowserImplicitTimeOut(int webBrowserImplicitTimeOut) {
        this.webBrowserImplicitTimeOut = webBrowserImplicitTimeOut;
    }

    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setWebListener(WebListener webListener) {
        this.webListener = webListener;
    }

    public void setDriver(EventFiringWebDriver driver) {
        this.driver = driver;
    }

}
