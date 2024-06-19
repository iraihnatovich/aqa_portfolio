package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import service.WaitsService;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver, Duration.ofSeconds(ReadProperties.getTimeout()));
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return waitsService.waitForVisibility(getPageIdentifier()).isDisplayed();
    }
}
