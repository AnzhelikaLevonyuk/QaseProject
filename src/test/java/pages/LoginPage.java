package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static String USER_NAME = "[name='email']";
    private final static String PASSWORD = "[name='password']";
    private final static String LOGIN_BUTTON = ".Ipyboe";

    @Step("Fill login form email: '{email}' and password: '{password}'")
    public void login(String email, String password) {
        $(USER_NAME).setValue(email);
        $(PASSWORD).setValue(password);
        $(LOGIN_BUTTON).shouldBe(clickable).click();
    }

}
