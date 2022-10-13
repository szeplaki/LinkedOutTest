package registerTest;

import java.util.UUID;

import org.example.Model.LoginModel;
import org.example.WebDriverService;
import org.example.Model.register.CompanyRegisterModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanyRegisterTest {

	CompanyRegisterModel model;

	@BeforeEach
	public void beforeEach()
	{
		model = new CompanyRegisterModel();
		model.openUrlWithSpecificPathAndMaximizeWindowSize("/");
	}

	@AfterEach
	public void afterEach() {
		WebDriverService.getInstance().quitWebDriver();
	}

	@Test
	public void SuccessfulCompanyRegistration() {
		String name = UUID.randomUUID().toString();
		String email = "any@thing.mail";
		String password = "password";
		String phone = "walkie talkie";
		String city = "Budapest";
		model.openForm();

		model.setName(name);
		model.setEmail(email);
        model.setPassword(password);
        model.setConfirmPassword(password);
        model.setPhone(phone);
        model.setCity(city);

		model.clickRegisterButton();

        boolean redirectedToMainPage = model.isMainPage();

        LoginModel loginModel = new LoginModel();
		loginModel.getLoginPage();
        loginModel.loginWithProvidedUsernameAndPassword(name,password);

		boolean isLoggedIn = model.isLoggedIn();

		Assertions.assertTrue(redirectedToMainPage,"Registration did not give any errors");
		Assertions.assertTrue(isLoggedIn,"Successfully logged in with registered account");
	}









}
