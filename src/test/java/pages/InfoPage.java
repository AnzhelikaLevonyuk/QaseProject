package pages;

import models.Project;
import models.Suite;
import models.TestCase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class InfoPage extends BasePage {

    public boolean isProjectTitleDisplayed(String projectName) {
        return $(".Qt9eBT").shouldBe(visible).shouldHave(text(projectName)).isDisplayed();
    }

    public Project getProjectInfo() {
        Project resultProject = Project.builder()
                .setName($(".Qt9eBT").shouldBe(visible).getText())
                .setCode($(".pOpqJc").shouldBe(visible).getText().replace(" repository", ""))
                .build();
        return resultProject;
    }

    public void clickCreateNewCaseButton() {
        $("#create-case-button").shouldBe(clickable).click();
    }

    public void clickCreateNewSuiteButton() {
        $("#create-suite-button").shouldBe(clickable).click();
    }

    public boolean isTestCaseNameDisplayed(String testCaseName) {
        return $("h1[class = 'XGG7C9']").shouldBe(visible).shouldHave(text(testCaseName)).isDisplayed();
    }

    public void clickPropertiesTab() {
        $(byXpath("//button[text()='Properties']")).click();
    }

    public TestCase getTestCaseInfo() {
        TestCase resultTestCase = TestCase.builder()
                .setTitle($("h1[class = 'XGG7C9']").shouldBe(visible).getText())
                .setDescription($(byXpath("//label[text()='Description']/..//p")).getText())
                .setPreConditions($(byXpath("//label[text()='Pre-conditions']/..//p")).getText())
                .setPostConditions($(byXpath("//label[text()='Post-conditions']/..//p")).getText())
                .setParameterTitle($(byXpath("//h3[text()='Parameters']/..//div[@class = 'HD7yQM']/div")).getText())
                .setParameterValue($(byXpath("//h3[text()='Parameters']/..//li")).getText())
                .build();
        return resultTestCase;
    }

    public Suite getSuiteInfo() {
        Suite resultSuite = Suite.builder()
                .setSuiteName($(byXpath("//div[@class ='q59KEA']//h3")).shouldBe(visible).getText())
                .setDescription($("[class ='toastui-editor-contents'] p").shouldBe(visible).getText())
                .build();
        return resultSuite;
    }
}
