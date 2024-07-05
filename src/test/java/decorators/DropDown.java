package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DropDown extends BaseElement {
    private final static String option = "//div[text()='%s']";


    public DropDown (String label) {
        super(label);
    }

    public void selectOption (String value) {
      this.element.click();
      getWebDriver().findElement(By.xpath(String.format(option,value))).click();
    }
}
