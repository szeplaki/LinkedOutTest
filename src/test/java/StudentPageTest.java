import org.example.Model.StudentPageModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentPageTest {
    private StudentPageModel studentPageModel;

    @BeforeEach
    public void setProperties() {
        studentPageModel = new StudentPageModel();
    }

    @AfterEach
    public void closeTab() {
        WebDriverService.getInstance().quitWebDriver();
    }

    @Test
    public void openStudentPageWhileLoggedIn() {
        studentPageModel.doLogin();
        studentPageModel.waitUntilWebElementIsClickable("id", "logout");

        studentPageModel.openUrlWithSpecificPathAndMaximizeWindowSize("/student/list-all");
        studentPageModel.waitUntilWebElementIsVisible("className", "AllStudentHeader");

        Assertions.assertEquals("List of all available CoodCooler", studentPageModel.getStudentHeaderText());
    }

    @Test
    public void openStudentPageWithoutLogin(){
        studentPageModel.openUrlWithSpecificPathAndMaximizeWindowSize("/student/list-all");
        studentPageModel.waitUntilWebElementIsVisible("xpath", "//*[@id='root']/p");

        Assertions.assertEquals("You are not authorized to see this webpage!", studentPageModel.getNotAuthorizedMsg());
    }
}
