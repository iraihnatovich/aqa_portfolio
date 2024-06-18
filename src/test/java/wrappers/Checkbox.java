package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    private UiElement uiElement;

    public Checkbox(WebDriver driver, By locator) {
        this.uiElement = new UiElement(driver, locator);
    }

    public Checkbox(WebDriver driver, WebElement webElement) {
        this.uiElement = new UiElement(driver, webElement);
    }

    public boolean isDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    private void setStatus(boolean status) {
        if (isSelected() != status) {
            uiElement.click();
        }
    }

    public void select() {
        setStatus(true);
    }

    public void remove() {
        setStatus(false);
    }
}
