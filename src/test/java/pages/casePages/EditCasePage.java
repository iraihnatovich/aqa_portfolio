package pages.casePages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Button;
import wrappers.UiElement;

public class EditCasePage extends BasePage {
    private final By buttonAttachmentTabLocator = By.xpath("//span[@data-testid='item-attachments']");
    private final By documentAttachmentLocator = By.xpath("//*[@target='_blank']");
    private final By crossButtonLocator = By.xpath("//button[@title='Close']");
    private final By addAttachmentElementLocator = By.xpath("//*[@type='file']");

    public EditCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return buttonAttachmentTabLocator;
    }

    public Button getButtonAttachmentTab() {
        return new Button(driver, buttonAttachmentTabLocator);
    }

    public Button getCrossButton() {
        return new Button(driver, crossButtonLocator);
    }

    public UiElement getAddAttachmentElement() {
        return new UiElement(driver, addAttachmentElementLocator);
    }

    public UiElement getDocAttachmentElement() {
        return new UiElement(driver, documentAttachmentLocator);
    }

    public EditCasePage switchToAttachmentTab() {
        getButtonAttachmentTab().click();
        return this;
    }

    public AllCasePage closeEditCasePageByCross() {
        getCrossButton().click();
        return new AllCasePage(driver);
    }

    public void chooseFileForAttachment(String filePath) {
        getAddAttachmentElement().sendKeys(filePath);
    }

    public boolean isDocumentAttached() {
        return getDocAttachmentElement().isDisplayed();
    }

}
