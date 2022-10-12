package org.example.Model;

public class LoginModel extends BaseModel {
    public void loginWithProvidedUsernameAndPassword(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getLogoutButtonText(){
        return logoutButton.getText();
    }
}
