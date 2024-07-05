package modals;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationModal {
    public void clickDeleteProjectButton(){
        $(".ReactModal__Content").shouldBe(visible);
        $(byXpath("//span[text()='Delete project']")).shouldBe(clickable).click();
    }
}
