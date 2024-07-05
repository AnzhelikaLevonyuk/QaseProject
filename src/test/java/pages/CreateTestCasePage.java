package pages;

import decorators.DropDown;
import io.qameta.allure.Step;
import models.TestCase;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateTestCasePage {
    @Step("Creating new TestCase")
    public void createTestCase(TestCase testCase) throws InterruptedException {

        $("#title").setValue(testCase.getTitle());
        new DropDown("Status").selectOption(testCase.getStatus().getName());
        $(byXpath("//label[text()='Description']/..//div/p")).setValue(testCase.getDescription());
        new DropDown("Severity").selectOption(testCase.getSeverity().getName());
        new DropDown("Priority").selectOption(testCase.getPriority().getName());
        new DropDown("Type").selectOption(testCase.getType().getName());
        new DropDown("Layer").selectOption(testCase.getLayer().getName());
        new DropDown("Is flaky").selectOption(testCase.getIsFlaky().getName());
        new DropDown("Behavior").selectOption(testCase.getBehavior().getName());
        new DropDown("Automation status").selectOption(testCase.getAutomationStatus().getName());
        $(byXpath("//label[text()='Pre-conditions']/..//div/p")).setValue(testCase.getPreConditions());
        $(byXpath("//label[text()='Post-conditions']/..//div/p")).setValue(testCase.getPostConditions());

        $("#case-attachments button").click();
        $("[placeholder = 'Parameter title']").setValue(testCase.getParameterTitle());
        $("[placeholder = 'Parameter value']").setValue(testCase.getParameterValue());

//Поле Data не заполняется данными???!!!
        //        $(byXpath("//span[text()=' Add step']/..")).click();
//        try {
//            Thread.sleep(2000);
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
//
//        $(byXpath("//p[@data-placeholder='Step Action']")).click();
//        $(byXpath("//p[@data-placeholder='Step Action']")).sendKeys(testCase.getStepAction());
//
//
//        $(byXpath("//p[@data-placeholder='Data']")).click();
//        $(byXpath("//p[@data-placeholder='Data']")).sendKeys(testCase.getData());
//
//
//        $(byXpath("//p[@data-placeholder='Expected result']")).click();
//        $(byXpath("//p[@data-placeholder='Expected result']")).sendKeys(testCase.getExpectedResult());

        $("#save-case").click();

    }
}
