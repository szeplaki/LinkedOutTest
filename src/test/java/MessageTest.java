import org.example.Model.MessageModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {
    private MessageModel messageModel;

    @BeforeEach
    public void setProperties() {
        messageModel = new MessageModel();
        messageModel.getLoginPage();
    }

    @AfterEach
    public void closeTab() {
        WebDriverService.getInstance().quitWebDriver();
    }

    @Test
    public void sendMessageLoggedIn(){

    }

    @Test
    public void sendMessageLoggedOut(){
        messageModel.doLogin();
        messageModel.openUrlWithSpecificPathAndMaximizeWindowSize("/student/list-all");

        messageModel.waitUntilWebElementIsVisible("xpath", "//*[@id='root']/p");

        Assertions.assertEquals("You are not authorized to see this webpage!", messageModel.getNotAuthorizedMsg());
    }
}
