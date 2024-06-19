package apiServices;

import models.Project;

public interface IProjectService {
    Project addProject(Project project);

    Project addSetupProject();

    int deleteProject(int projectID);

    int getProjectByInvalidId(int projectID);
}
