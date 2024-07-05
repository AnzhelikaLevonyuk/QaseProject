package pages;

import io.qameta.allure.Step;
import models.Project;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage extends BasePage {
    @Step("Creating new project")
    public void createNewProject(Project project) {
        $("#project-name").setValue(project.getName());
        $("#project-code").setValue(project.getCode());
        $("#description-area").setValue(project.getDescription());
        $("button[type='submit']").shouldBe(clickable).click();
    }
}
