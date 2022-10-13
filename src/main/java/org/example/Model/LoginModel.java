package org.example.Model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModel extends BaseModel {
    @FindBy(className = "login-error")
    private WebElement incorrectLoginMsg;

    public void loginWithProvidedUsernameAndPassword(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getLogoutButtonText() {
        return logoutButton.getText();
    }

    public String getIncorrectLoginMsg() {
        return incorrectLoginMsg.getText();
    }

    public String getLoginUrl() {
        return webDriver.getCurrentUrl();
    }
}
