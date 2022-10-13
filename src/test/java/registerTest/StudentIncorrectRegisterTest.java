package registerTest;

import org.example.Model.register.StudentRegisterModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentIncorrectRegisterTest {
    private static StudentRegisterModel model;

    @BeforeAll
    public static void beforeAll() {
        model = new StudentRegisterModel();
    }
    @AfterAll
    public static void afterAll() {
        WebDriverService.getInstance().quitWebDriver();
    }

    @Test
    public void requiredFieldsNameTest()
    {
        String age = "20";
        String password = "password";
        String email = "em@a.il";

        model.openForm();

        model.setAge(age);
        model.setEmailField(email);
        model.setPassword(password);
        model.setPasswordAgain(password);

        model.clickRegisterButton();

        Assertions.assertFalse(model.isMainPage());
    }

    @Test
    public void requiredFieldsAgeTest()
    {
        String name = "name";
        String password = "password";
        String email = "em@a.il";

        model.openForm();

        model.setName(name);
        model.setEmailField(email);
        model.setPassword(password);
        model.setPasswordAgain(password);

        model.clickRegisterButton();

        Assertions.assertFalse(model.isMainPage());
    }

    @Test
    public void requiredFieldsEmailTest()
    {
        String name = "name";
        String age = "20";
        String password = "password";


        model.openForm();

        model.setName(name);
        model.setAge(age);
        model.setPassword(password);
        model.setPasswordAgain(password);

        model.clickRegisterButton();

        Assertions.assertFalse(model.isMainPage());
    }

    @Test
    public void requiredFieldsPasswordTest()
    {
        String name = "name";
        String age = "20";
        String password = "password";
        String email = "em@a.il";

        model.openForm();

        model.setName(name);
        model.setAge(age);
        model.setEmailField(email);
        model.setPasswordAgain(password);

        model.clickRegisterButton();

        Assertions.assertFalse(model.isMainPage());
    }

    @Test
    public void requiredFieldsPasswordAgainTest()
    {
        String name = "name";
        String age = "20";
        String password = "password";
        String email = "em@a.il";

        model.openForm();

        model.setName(name);
        model.setAge(age);
        model.setEmailField(email);
        model.setPassword(password);

        model.clickRegisterButton();

        Assertions.assertFalse(model.isMainPage());
    }
}

