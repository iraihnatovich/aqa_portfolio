package wrappers.modalWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;

public class ThreeOptionsModal extends TwoOptionsModal {
    private Button buttonDiscard;

    public ThreeOptionsModal(WebDriver driver, By windowLocator,
                             By confirmButtonLocator, By cancelButtonLocator, By buttonDiscardLocator) {
        super(driver, windowLocator, confirmButtonLocator, cancelButtonLocator);
        this.buttonDiscard = new Button(driver, buttonDiscardLocator);
    }

    public void discardAndClose() {
        buttonDiscard.click();
    }

    public boolean isButtonDiscardEnabled() {
        return buttonDiscard.isEnabled();
    }
}
