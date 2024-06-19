package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    private UiElement uiElement;

    public Button(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public Button(WebDriver driver, WebElement webElement) {
        this.uiElement = new UiElement(driver, webElement);
    }

    public void click() {
        uiElement.click();
    }

    public String getText() {
        return uiElement.getText();
    }

    public void submit() {
        uiElement.submit();
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isEnabled() {
        return uiElement.isEnabled();
    }
}
