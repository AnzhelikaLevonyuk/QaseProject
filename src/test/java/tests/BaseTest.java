package tests;

import com.codeborne.selenide.Configuration;
import modals.ConfirmationModal;
import models.Project;
import models.Suite;
import models.TestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;
import utils.TestDataGeneration;

import static com.codeborne.selenide.Selenide.open;


public abstract class BaseTest {
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected CreateProjectPage createProjectPage;
    protected InfoPage infoPage;
    protected ConfirmationModal confirmationModal;
    protected CreateTestCasePage createTestCasePage;
    protected CreateSuitePage createSuitePage;

    protected Project project;
    protected TestCase testCase;
    protected Suite suite;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.baseUrl = PropertyReader.getProperty("base_url");
        Configuration.timeout = 8000;
        Configuration.webdriverLogsEnabled = true;
        Configuration.reportsFolder = "target/build";

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        createProjectPage = new CreateProjectPage();
        infoPage = new InfoPage();
        confirmationModal = new ConfirmationModal();
        createTestCasePage = new CreateTestCasePage();
        createSuitePage = new CreateSuitePage();

        open("/");
    }

    @BeforeMethod(onlyForGroups = "userShouldBeLogin", alwaysRun = true)
     public void userShouldBeLogin() {
        loginPage.login(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }

    @BeforeMethod(dependsOnMethods = {"setUp","userShouldBeLogin"}, onlyForGroups = "ProjectShouldBeCreated")
    public void createProject() {
        project = TestDataGeneration.generateProject();

        projectsPage.clickCreateNewProjectButton();
        createProjectPage.createNewProject(project);
        infoPage.clickOnProjectsTab();
    }

    @AfterMethod(onlyForGroups = "projectShouldBeDeleted",alwaysRun = true)
    public void projectShouldBeDeleted() {
        infoPage.clickOnProjectsTab();
        projectsPage.deleteProject(project.getName());
        confirmationModal.clickDeleteProjectButton();
    }

}
