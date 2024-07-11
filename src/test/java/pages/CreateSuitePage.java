package pages;

import io.qameta.allure.Step;
import models.Suite;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateSuitePage extends BasePage {
    private final static String option = "//div[text()='%s']";

    public void selectOption(String value) {
        getWebDriver().findElement(By.xpath(String.format(option, value))).click();
    }

    @Step("Creating new Suite")
    public void createNewSuite(Suite suite) {
        $("#title").setValue(suite.getSuiteName());
        $(byXpath("//label[text()='Parent suite']/../..//span")).click();
        waiting();
        selectOption(suite.getParentSuite().getName());
        $(byXpath("//label[text()='Description']/../../div//p")).setValue(suite.getDescription());
        $(byXpath("//label[text()='Preconditions']//..//following-sibling::div//p")).setValue(suite.getPreconditions());
        $("button[type='submit']").shouldBe(clickable).click();
    }
}
