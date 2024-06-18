package baseEntities;

import apiServices.ProjectService;
import apiServices.TestCaseService;
import com.github.javafaker.Faker;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.TestCase;
import models.User;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import service.BrowserService;
import service.WaitsService;
import utils.InvokedListener;

import static io.restassured.RestAssured.given;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected User setupUser;
    protected Project setupProject;
    protected TestCase setupCase;
    protected ProjectService projectService;
    protected TestCaseService testCaseService;

    protected WebDriver driver;
    protected WaitsService waitsService;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected Faker faker;

    @BeforeTest
    public void auth() {
        RestAssured.baseURI = ReadProperties.getBaseApiUrl();
        RestAssured.requestSpecification = given()
                .header("X-Api-Key", ReadProperties.getApiKey())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

    @BeforeClass
    public void createData() {
        setupUser = User.builder().email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword()).build();
        projectService = new ProjectService();
        testCaseService = new TestCaseService();
        faker = new Faker();

        setupProject = projectService.addSetupProject();
        setupCase = TestCase.builder().title(faker.rockBand().name()).projectID(setupProject.getId()).build();
        setupCase = testCaseService.addCase(setupCase);

    }

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserService().getDriver();
        this.setDriverToContext(iTestContext, driver);
        waitsService = new WaitsService(driver);

        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
        dashboardPage =  loginPage.successfulLogIn(setupUser);
        dashboardPage.selectProjectByText(setupProject.getName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void purge() {
        projectService.deleteProject(setupProject.getId());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
        return (WebDriver) iTestContext.getAttribute("WebDriver");
    }
}
