package apiServices;

import io.restassured.mapper.ObjectMapperType;
import models.TestCase;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestCaseService implements ITestCaseService {
    @Override
    public TestCase getSingleCase(int caseID) {
        return given()
                .pathParam("caseID", caseID)
                .get(Endpoints.GET_SINGLE_CASE_BY_ID)
                .then().log().body()
                .extract()
                .as(TestCase.class);
    }

    @Override
    public TestCase addCase(TestCase testCase) {
        return given()
                .body(testCase, ObjectMapperType.GSON)
                .log().body()
                .post(Endpoints.CREATE_NEW_CASE)
                .then()
                .log().body()
                .extract()
                .as(TestCase.class);
    }

    @Override
    public int getCaseByInvalidId(int caseID) {
        return given()
                .pathParam("caseID", caseID)
                .get(Endpoints.GET_SINGLE_CASE_BY_ID)
                .then()
                .log().body()
                .extract()
                .response()
                .getStatusCode();
    }
}
