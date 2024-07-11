package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage extends BasePage {
    private static final String DELETE_PROJECT_CONTAINER = "//tbody[@class = 'YtumFo'] //a[text() = '%s']//ancestor:: td/following::td[5]//span";

    @Step("Click 'Create new project' button")
    public void clickCreateNewProjectButton() {
        $("#createButton").shouldBe(clickable).click();
    }

    public boolean isProjectDisplayed(String projectName) {
        $(".cx2QU4").shouldBe(visible);
        return $$(".cx2QU4").stream().anyMatch(project -> project.getText().equals(projectName));
    }

    @Step("Open Project info page")
    public void openProjectInfoPage(String projectName) {
        $$(".cx2QU4").findBy(exactText(projectName)).shouldBe(visible).click();
    }

    @Step("Delete {projectName} project ")
    public void deleteProject(String projectName) {
        $(byXpath(String.format(DELETE_PROJECT_CONTAINER, projectName))).click();
        $(".fwhtHZ").click();
    }


}
