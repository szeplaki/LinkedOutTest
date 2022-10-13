package org.example.Model.register;

import org.example.FileReader;
import org.example.Model.BaseModel;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StudentRegisterModel extends BaseModel {
    @FindBy(xpath = "//*[@id='root']//div[@class='welcome']")
    private WebElement welcomeScreen;


    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "psw")
    private WebElement passwordField;

    @FindBy(id = "psw_again")
    private WebElement passwordAgainField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void setEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void setPasswordAgain(String passwordAgain) {
        passwordAgainField.clear();
        passwordAgainField.sendKeys(passwordAgain);
    }

    public void setCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void openForm() {
		// Could not find a way to click on the button
        webDriver.get(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl") + "/student/registration");
    }

    public boolean isMainPage() {
        WebDriverWait shortWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        try {
            shortWait.until(ExpectedConditions.visibilityOf(welcomeScreen));
            return true;
        }
        catch (TimeoutException ignore) {
            return false;
        }
    }
}
