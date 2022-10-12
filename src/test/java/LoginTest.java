import org.example.FileReader;
import org.example.Model.LoginModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
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
        // TODO assert after successful login
        loginModel.loginWithProvidedUsernameAndPassword(FileReader.getValueByKeyFromConfigProperties("linkedout.username"),
                                                    FileReader.getValueByKeyFromConfigProperties("linkedout.password"));
    }
}
