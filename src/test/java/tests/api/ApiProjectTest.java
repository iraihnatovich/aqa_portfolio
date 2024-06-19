package tests.api;

import apiServices.ProjectService;
import apiServices.TestCaseService;
import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Project;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ApiProjectTest extends BaseApiTest {
    private Project expectedProject;
    private Project actualProject;
    private String jsonProjectDoc;

    @BeforeClass
    public void dataSetup() {
        gson = new Gson();
        testCaseService = new TestCaseService();
        projectService = new ProjectService();

        try {
            jsonProjectDoc = FileUtils.readFileToString(new File(ApiCaseTest.class.getClassLoader()
                    .getResource("apiTestData/projectAPI.json").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedProject  = gson.fromJson(jsonProjectDoc, Project.class);
    }

    @Test(testName = "Add project")
    @Description("Validation of Adding project")
    @Severity(SeverityLevel.BLOCKER)
    public void createProjectTest() {
        actualProject = projectService.addProject(expectedProject);

        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test(testName = "Get project by invalid ID")
    @Description("Get project by invalid ID - negative test")
    @Severity(SeverityLevel.NORMAL)
    public void getProjectWithInvalidIdTest() {
        int responseStatusCode = projectService.getProjectByInvalidId(new Faker().number()
                .numberBetween(2000, 17000));

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }

    @Test (testName = "Delete project", dependsOnMethods = "createProjectTest")
    @Description("Delete existent project")
    @Severity(SeverityLevel.NORMAL)
    public void deleteProject() {
        Project existentProject = actualProject;
        projectService.deleteProject(existentProject.getId());
        int responseStatusCode = projectService.getProjectByInvalidId(existentProject.getId());

        Assert.assertEquals(responseStatusCode, HttpStatus.SC_NOT_FOUND);
    }
}
