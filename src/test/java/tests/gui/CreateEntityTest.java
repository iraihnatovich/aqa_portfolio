package tests.gui;

import baseEntities.BaseTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEntityTest extends BaseTest {
    private TestCase createdCase;

    @Test
    public void createCaseEntityTest() {
        createdCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();

        Assert.assertTrue(
                dashboardPage.navigateToCasesPage()
                        .createNewCase()
                        .enterCaseTitle(createdCase)
                        .clickCreateButton()
                        .isCaseInGrid(createdCase));
    }
}
