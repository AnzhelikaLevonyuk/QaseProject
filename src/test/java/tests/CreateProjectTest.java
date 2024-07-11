package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateProjectTest extends BaseTest {

    @Test(groups = "userShouldBeLogin")
    public void createNewProjectTest() {
        project = TestDataGeneration.generateProject();

        projectsPage.clickCreateNewProjectButton();
        createProjectPage.createNewProject(project);
        Assert.assertTrue(infoPage.isProjectTitleDisplayed(project.getName()));
        Project actualProject = infoPage.getProjectInfo();
        Assert.assertEquals(actualProject, project);

        createProjectPage.clickOnProjectsTab();
        Assert.assertTrue(projectsPage.isProjectDisplayed(project.getName()));
    }

}
