package pages.casePages;

import baseEntities.BasePage;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.UiElement;
import wrappers.modalWindow.TwoOptionsModal;

import java.util.ArrayList;
import java.util.List;

public class AllCasePage extends BasePage {
    private final By createNewTestCaseLocator = By.xpath("//button[@data-testid='button-add']");
    private final By caseTitleLocator = By.xpath("//div[@data-testid='cell-title']");
    private final By caseCheckBoxesLocator = By.xpath("//div[@data-testid='cell-select']");
    private final By deleteCaseButtonLocator = By.xpath("//button[@data-testid='button-delete']");
    private final By deleteModalWindowLocator = By.xpath("//div[@data-testid='section-modal-messagebox']");
    private final By confirmButtonModalLocator = By.xpath("//button[@data-testid='button-affirm']");
    private final By cancelButtonModalLocator = By.xpath("//button[@data-testid='button-cancel']");

    public AllCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return createNewTestCaseLocator;
    }

    public Button getCreateNewCaseButton() {
        return new Button(driver, createNewTestCaseLocator);
    }

    public Button getDeleteCaseButton() {
        return new Button(driver, deleteCaseButtonLocator);
    }

    public TwoOptionsModal getDeleteModalWindow() {
        return new TwoOptionsModal(driver, deleteModalWindowLocator,
                confirmButtonModalLocator, cancelButtonModalLocator);
    }

    public List<UiElement> getCaseTitleList() {
        List<WebElement> webElementsList = waitsService.waitForVisibilityAllElements(caseTitleLocator);
        List<UiElement> uiElementList = new ArrayList<>();
        for (WebElement webElement : webElementsList) {
            uiElementList.add(new UiElement(driver, webElement));
        }
        return uiElementList;
    }

    private List<Checkbox> getCaseCheckboxesList() {
        List<WebElement> webElementsList = waitsService.waitForVisibilityAllElements(caseCheckBoxesLocator);
        List<Checkbox> checkboxesList = new ArrayList<>();
        for (WebElement webElement : webElementsList) {
            checkboxesList.add(new Checkbox(driver, webElement));
        }
        return checkboxesList;
    }

    public Checkbox getCaseCheckbox(TestCase testCase) {
        List<Checkbox> checkboxesList = getCaseCheckboxesList();
        List<UiElement> uiElementList = getCaseTitleList();
        for (UiElement uiElement : uiElementList) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                return checkboxesList.get(uiElementList.indexOf(uiElement));
            }
        }
        return null;
    }

    public AllCasePage clickDeleteCaseButton() {
        getDeleteCaseButton().click();
        return this;
    }

    public AllCasePage selectCaseCheckbox(TestCase testCase) {
        getCaseCheckbox(testCase).select();
        return this;
    }

    public boolean isCaseInGrid(TestCase testCase) {
        for (UiElement uiElement : getCaseTitleList()) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public EditCasePage openCase(TestCase testCase) {
        for (UiElement uiElement : getCaseTitleList()) {
            if (uiElement.getText().trim().equals(testCase.getTitle())) {
                uiElement.click();
                return new EditCasePage(driver);
            }
        }
        return null;
    }

    public void clickCreateNewTestButton() {
        getCreateNewCaseButton().click();
    }

    public CreateCasePage createNewCase() {
        clickCreateNewTestButton();
        return new CreateCasePage(driver);
    }

    public boolean isModalWindowDisplayed() {
        return getDeleteModalWindow().isWindowDisplayed();
    }

    public AllCasePage confirmCaseDeletion() {
        getDeleteModalWindow().confirmAction();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AllCasePage(driver);
    }

    public AllCasePage cancelCaseDeletion() {
        getDeleteModalWindow().cancelAction();
        return this;
    }
}
