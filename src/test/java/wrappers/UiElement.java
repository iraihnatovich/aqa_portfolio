package wrappers;

import configuration.ReadProperties;
import org.openqa.selenium.*;
import service.WaitsService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UiElement implements WebElement {
    private WebDriver driver;
    private WaitsService wait;
    private WebElement webElement;

    private UiElement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitsService(driver, Duration.ofSeconds(ReadProperties.getTimeout()));
    }

    public UiElement(WebDriver driver, By locator) {
        this(driver);
        this.webElement = wait.waitForExistInDom(locator);
    }

    public UiElement(WebDriver driver, WebElement webElement) {
        this(driver);
        this.webElement = webElement;
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotInteractableException exception) {
            try {
                moveToElement();
                webElement.click();
            } catch (ElementNotInteractableException exception1) {
                moveToElement();
                webElement.click();
            }
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        moveToElement();
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText().trim();
    }

    @Override
    public List<WebElement> findElements(By locator) {
        return webElement.findElements(locator);
    }

    public List<UiElement> findUiElements(By locator) {
        List<UiElement> uiElementsList = new ArrayList<UiElement>();
        for (WebElement webElement : findElements(locator)) {
            uiElementsList.add(new UiElement(driver, webElement));
        }
        return uiElementsList;
    }

    @Override
    public UiElement findElement(By locator) {
        return new UiElement(driver, locator);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void moveToElement() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
