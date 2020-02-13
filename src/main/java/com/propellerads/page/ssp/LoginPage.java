package com.propellerads.page.ssp;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginInput = $("#username");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement submitButton = $("button[type='submit']");

    public MainPage login(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        submitButton.click();
        return new MainPage();
    }
}
