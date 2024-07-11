package tests;

import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateTestCaseTest extends BaseTest {
    @Test(groups = {"userShouldBeLogin","ProjectShouldBeCreated","projectShouldBeDeleted"})
    public void createTestCase(){

        testCase = TestDataGeneration.generateTestCase();

        projectsPage.openProjectInfoPage(project.getName());
        infoPage.clickCreateNewCaseButton();

        createTestCasePage.createTestCase(testCase);
        Assert.assertTrue(infoPage.isTestCaseNameDisplayed(testCase.getTitle()));

        TestCase actualTestCase = infoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, testCase);
    }

}
