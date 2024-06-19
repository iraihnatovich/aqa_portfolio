package service;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType;

    public BrowserService() {
        switch (ReadProperties.getBrowser()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                System.out.println(ReadProperties.getBrowser() + " is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        driver.manage().deleteAllCookies();
        return driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");

        return chromeOptions;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--silent");
        firefoxOptions.addArguments("--incognito");

        return firefoxOptions;
    }
}
