package tests.gui;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteEntityTest extends BaseTest {
    private TestCase caseForDeletion;

    @BeforeClass
    public void addTestCasesToProject() {
        caseForDeletion = TestCase.builder().title("dummy case for Delete test")
                .projectID(setupProject.getId()).build();
        testCaseService.addCase(caseForDeletion);
    }


    @Test
    @Description("Modal widow displaying after clicking delete button")
    @Severity(SeverityLevel.NORMAL)
    public void deleteCaseModalPresenceTest() {
        Assert.assertTrue(
                dashboardPage.navigateAllCasesPage()
                        .selectCaseCheckbox(setupCase)
                        .clickDeleteCaseButton()
                        .isModalWindowDisplayed()
        );
    }

    @Test
    @Description("Test case deleting")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteCaseTest() {
        Assert.assertFalse(
                dashboardPage.navigateAllCasesPage()
                        .selectCaseCheckbox(caseForDeletion)
                        .clickDeleteCaseButton()
                        .confirmCaseDeletion()
                        .isCaseInGrid(caseForDeletion)
        );
    }
}
