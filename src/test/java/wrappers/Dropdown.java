package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Dropdown {
    private List<UiElement> uiElementListDropDown;
    private List<String> elementTextList;
    private UiElement uiElementCore;

    public Dropdown(WebDriver driver, By locatorCore) {
        uiElementCore = new UiElement(driver, locatorCore);
        uiElementListDropDown = uiElementCore.findUiElements(By.xpath("*/descendant::li"));
        elementTextList = new ArrayList<String>();
    }

    private List<String> setElementTextList() {
        for (UiElement uiElement: uiElementListDropDown) {
            elementTextList.add(uiElement.getText());
        }
        return elementTextList;
    }

    public void setByText(String text) {
        uiElementListDropDown.get(setElementTextList().indexOf(text)).click();
    }
}
