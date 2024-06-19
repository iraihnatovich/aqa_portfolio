package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextMessage {
    private UiElement uiElement;

    public TextMessage(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public String getText() {
        return uiElement.getText().trim();
    }
}
