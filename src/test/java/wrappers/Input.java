package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    private UiElement uiElement;

    public Input(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public void sendKeys(CharSequence... keysToSend) {
        uiElement.sendKeys(keysToSend);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public void clearAndSendKeys(CharSequence... keysToSend) {
        uiElement.click();
        sendKeys(keysToSend);
    }

    public String getText() {
        return uiElement.getText().trim();
    }
}
