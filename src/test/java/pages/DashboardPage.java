package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.casePages.AllCasePage;
import wrappers.Button;
import wrappers.Dropdown;

public class DashboardPage extends BasePage {
    private final By openDropdownButtonLocator = By.xpath("//button[@data-testid='button-projects']");
    private final By coreDropdownLocator = By.id("portal-root");
    private final By creatingFirstTestCase = By.xpath("//h4[contains(text(),'Create test cases')]");
    private final By creatingTestRun = By.xpath("//h4[contains(text(),'Create a test run')]");
    private final By leftSideBarTC = By.cssSelector("[data-testid='item-testcases']");
    private final By leftSideBarTR = By.cssSelector("[data-testid='item-testruns']");
    private final By greetingMessageLocator = By.xpath("//h1[@data-testid='text-dashboard-header-content']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return greetingMessageLocator;
    }

    public Button getCreateFirstTestCaseButton() {
        return new Button(driver, creatingFirstTestCase);
    }

    public Button getCreateTestRunButton() {
        return new Button(driver, creatingTestRun);
    }

    public Button getLeftSideBarTCButton() {
        return new Button(driver, leftSideBarTC);
    }

    public Button getLeftSideBarTRButton() {
        return new Button(driver, leftSideBarTR);
    }

    public AllCasePage navigateAllCasesPage() {
        getLeftSideBarTCButton().click();
        return new AllCasePage(driver);
    }

    public void clickCreateFirstTestCaseButton() {
        getCreateFirstTestCaseButton().click();
    }

    public Button getProjectDropDownButton() {
        return new Button(driver, openDropdownButtonLocator);
    }

    private boolean isProjectSelected(String projectName) {
        return getProjectDropDownButton().getText().equals(projectName);
    }

    public AllCasePage startFirstTestCaseCreating() {
        clickCreateFirstTestCaseButton();
        return new AllCasePage(driver);
    }

    public Dropdown getProjectDropdown() {
        getProjectDropDownButton().click();
        return new Dropdown(driver, coreDropdownLocator);
    }

    public DashboardPage selectProjectByText(String text) {
        if (!isProjectSelected(text)) {
            getProjectDropdown().setByText(text);
        }
        return this;
    }
}
