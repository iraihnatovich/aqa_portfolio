package tests.gui;

import baseEntities.BaseTest;
import data.CaseTitleDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEntityTest extends BaseTest {
    private TestCase createdCase;

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Creating entity with correct data -- test case")
    public void createCaseEntityTest() {
        createdCase = TestCase.builder().title(faker.rockBand().name()).build();

        Assert.assertTrue(
                dashboardPage.navigateAllCasesPage()
                        .createNewCase()
                        .enterCaseTitle(createdCase)
                        .clickCreateButton()
                        .isCaseInGrid(createdCase));
    }

    @Test(dependsOnMethods = "createCaseEntityTest",
            dataProviderClass = CaseTitleDataProvider.class, dataProvider = "correctDataForCaseName")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Entering valid title -- test case")
    public void boundaryValidCaseTitleTest(String caseName) {
        TestCase expectedCase = TestCase.builder().title(caseName).build();

        Assert.assertTrue(
                dashboardPage.navigateAllCasesPage()
                        .createNewCase()
                        .enterCaseTitle(expectedCase)
                        .clickCreateButton()
                        .isCaseInGrid(expectedCase));
    }

    @Test(dependsOnMethods = "createCaseEntityTest",
            dataProviderClass = CaseTitleDataProvider.class, dataProvider = "incorrectDataForCaseName")
    @Severity(SeverityLevel.NORMAL)
    @Description("Entering invalid title -- test case")
    public void boundaryInvalidCaseTitleTest(String caseName) {
        Assert.assertFalse(
                dashboardPage.navigateAllCasesPage()
                        .createNewCase()
                        .enterCaseTitle(caseName)
                        .isCreateButtonEnabled());
    }

    @Test(dependsOnMethods = "createCaseEntityTest")
    @Severity(SeverityLevel.MINOR)
    @Description("Entering only spaces in title -- test case")
    public void incorrectInputCaseTitleTest() {
        Assert.assertEquals(
                dashboardPage.navigateAllCasesPage()
                        .createNewCase()
                        .enterCaseTitle("     ")
                        .getHintTitleErrorText(), "Must have at least 1 characters " +
                        "(leading/trailing white spaces not counted).");
    }

    @Test(dependsOnMethods = "createCaseEntityTest")
    @Severity(SeverityLevel.MINOR)
    @Description("Entering only spaces in title -- test case -- failed on purpose")
    public void failedOnPurposeTest() {
        Assert.assertEquals(
                dashboardPage.navigateAllCasesPage()
                        .createNewCase()
                        .enterCaseTitle("     ")
                        .getHintTitleErrorText(), "Must have at least 1");
    }
}
