package wrappers.modalWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UiElement;

public class TwoOptionsModal {
    private UiElement uiElement;
    private Button buttonConfirm;
    private Button buttonCancel;

    public TwoOptionsModal(WebDriver driver, By windowLocator, By confirmButtonLocator, By cancelButtonLocator) {
        this.uiElement = new UiElement(driver, windowLocator);
        this.buttonConfirm = new Button(driver, confirmButtonLocator);
        this.buttonCancel = new Button(driver, cancelButtonLocator);
    }

    public boolean isWindowDisplayed() {
        return uiElement.isDisplayed();
    }

    public boolean isButtonConfirmDisplayed() {
        return buttonConfirm.isDisplayed();
    }

    public boolean isButtonCancelDisplayed() {
        return buttonCancel.isDisplayed();
    }

    public boolean isButtonConfirmEnabled() {
        return buttonConfirm.isEnabled();
    }

    public boolean isButtonCancelEnabled() {
        return buttonCancel.isEnabled();
    }

    public void cancelAction() {
        buttonCancel.click();
    }

    public void confirmAction() {
        buttonConfirm.click();
    }
}
