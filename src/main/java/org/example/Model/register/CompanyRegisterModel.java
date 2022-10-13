package org.example.Model.register;

import org.example.FileReader;
import org.example.Model.BaseModel;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyRegisterModel extends BaseModel {
	@FindBy(xpath = "//*[@id='root']//div[@class='welcome']")
	private WebElement welcomeScreen;

	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(id = "phone")
	private WebElement phoneField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "register")
	private WebElement registerButton;

	@FindBy(id = "company-list")
	private WebElement companyListButton;

	public void setName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
	}
	
	public void setEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void setConfirmPassword(String confirmPassword) {
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(confirmPassword);
	}

	public void setPhone(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
	}

	public void setCity(String city) {
		cityField.clear();
		cityField.sendKeys(city);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	
    public void openForm() {
		// Could not find a way to click on the button
        webDriver.get(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl") + "/company/registration");
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

	public boolean isLoggedIn() {
		WebDriverWait shortWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		try {
			shortWait.until(ExpectedConditions.visibilityOf(companyListButton));
			return true;
		} catch (TimeoutException ignore) {
			return false;
		}
	}
}
