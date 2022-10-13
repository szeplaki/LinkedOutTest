package registerTest;

import org.example.Model.LoginModel;
import org.example.Model.register.StudentRegisterModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class StudentRegisterTest {
    StudentRegisterModel model;

    @BeforeEach
    public void beforeEach() {
        model = new StudentRegisterModel();
        model.openUrlWithSpecificPathAndMaximizeWindowSize("/");
    }

    @AfterEach
    public void afterEach() {
        WebDriverService.getInstance().quitWebDriver();
    }

    @Test
    public void SuccessfulStudentRegisterTest() {
        String name = UUID.randomUUID().toString();
        String password = "anything";
        String email = "test@gmail.com";
        String age = "20";

        model.openForm();

        model.setName(name);
        model.setPassword(password);
        model.setPasswordAgain(password);
        model.setEmailField(email);
         model.setAge(age);

         model.clickRegisterButton();

         boolean redirectedToMainPage = model.isMainPage();

        LoginModel loginModel = new LoginModel();
        loginModel.getLoginPage();
        loginModel.loginWithProvidedUsernameAndPassword(name, password);

        boolean isLoggedIn = model.isLoggedIn();

        Assertions.assertTrue(redirectedToMainPage,"Registration happened without problem");
        Assertions.assertTrue(isLoggedIn,"Successfully logged in with registered account");
    }
}
