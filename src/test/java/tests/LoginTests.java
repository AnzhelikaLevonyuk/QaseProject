package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginTest() {
        loginPage.login(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
        $(".uA6zAY").shouldBe(visible);
        Assert.assertTrue($(".uA6zAY").isDisplayed());
    }
}
