package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    @Step("Click 'Projects' tab")
    public void clickOnProjectsTab() {
        $(byText("Projects")).shouldBe(clickable).click();
    }

}
