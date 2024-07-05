package tests;

import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateSuiteTest extends BaseTest {

    @Test(groups = "ProjectShouldBeCreated")
    public void createNewSuite() throws InterruptedException {
        suite = TestDataGeneration.generateSuite();

        projectsPage.openProjectInfoPage(project.getName());
        infoPage.clickCreateNewSuiteButton();
        createSuitePage.createNewSuite(suite);

        Suite actualSuite = infoPage.getSuiteInfo();
        Assert.assertEquals(actualSuite, suite);
    }
}
