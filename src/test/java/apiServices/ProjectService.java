package apiServices;

import io.restassured.mapper.ObjectMapperType;
import models.Project;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectService implements IProjectService {

    @Override
    public Project addProject(Project project) {
        return given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract()
                .as(Project.class);
    }

    /**
     Creating project specified in: dataApiTest/setupProject.json
     */
    @Override
    public Project addSetupProject() {
        return given()
                .body(ProjectService.class.getClassLoader()
                        .getResourceAsStream("apiTestData/setupProject.json"))
                .log().body()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract()
                .as(Project.class);
    }

    @Override
    public int deleteProject(int projectID) {
        return given()
                .pathParam("projectID", projectID)
                .delete(Endpoints.DELETE_PROJECT_BY_ID)
                .then()
                .log().body()
                .extract()
                .statusCode();
    }

    @Override
    public int getProjectByInvalidId(int projectID) {
        return given()
                .pathParam("projectID", projectID)
                .get(Endpoints.GET_SINGLE_PROJECT_BY_ID)
                .then()
                .log().body()
                .extract()
                .response()
                .getStatusCode();
    }
}
