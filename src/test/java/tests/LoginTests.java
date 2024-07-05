package tests;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {
    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.baseUrl = PropertyReader.getProperty("base_url");
        Configuration.timeout = 8000;
        Configuration.webdriverLogsEnabled = true;
        Configuration.reportsFolder = "target/build";

        loginPage = new LoginPage();
        open("/");
    }

    @Test
    public void positiveLoginTest() {
        loginPage.login(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
        $(".uA6zAY").shouldBe(visible);
        Assert.assertTrue($(".uA6zAY").isDisplayed());
    }
}
