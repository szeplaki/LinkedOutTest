import org.example.FileReader;
import org.example.Model.LoginModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginModel loginModel;

    @BeforeEach
    public void setProperties(){
        loginModel = new LoginModel();
        loginModel.getLoginPage();
    }

    @AfterEach
    public void closeTab(){
        WebDriverService.getInstance().getWebDriver();
    }

    @Test
    public void successfulLogin(){
        loginModel.loginWithProvidedUsernameAndPassword(FileReader.getValueByKeyFromConfigProperties("linkedout.username"),
                                                    FileReader.getValueByKeyFromConfigProperties("linkedout.password"));

        loginModel.waitUntilWebElementIsClickable("id", "logout");
        Assertions.assertEquals("Logout", loginModel.getLogoutButtonText());
    }

    @Test
    public void loginWithInvalidUsername(){
        loginModel.loginWithProvidedUsernameAndPassword("whatever",
                FileReader.getValueByKeyFromConfigProperties("linkedout.password"));

        loginModel.waitUntilWebElementIsVisible("className", "login-error");
        Assertions.assertEquals(loginModel.getIncorrectLoginMsg(), "The username or password is incorrect!");

        loginModel.doLogin();
    }

    @Test
    public void loginWithInvalidPassword(){
        loginModel.loginWithProvidedUsernameAndPassword(FileReader.getValueByKeyFromConfigProperties("linkedout.username"),
                "whatever");

        loginModel.waitUntilWebElementIsVisible("className", "login-error");
        Assertions.assertEquals(loginModel.getIncorrectLoginMsg(), "The username or password is incorrect!");

        loginModel.doLogin();
    }
}
