import org.example.Model.MessageModel;
import org.example.WebDriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
    public void sendMessageLoggedIn() {
        Random random = new Random();
        int randomNumber = random.nextInt(100 - 1) + 1;
        String subject = "You are fired!";
        String from = "Darren";
        String msg = String.format("You are fired, don't come work tomorrow. Id: %d!", randomNumber);

        messageModel.doLogin();
        getOwnProfile();
        messageModel.clickOnSendMessage();
        messageModel.waitUntilWebElementIsClickable("id", "send-message-btn");

        messageModel.sendMessage(subject, from, msg);

        getOwnProfile();
        messageModel.clickOnInbox();
        messageModel.waitUntilWebElementIsVisible("className", "message-info");

        Assertions.assertTrue(messageModel.sentMessageFound(subject, from, msg));
    }

    @Test
    public void sendMessageLoggedOut() {
        messageModel.doLogin();
        messageModel.openUrlWithSpecificPathAndMaximizeWindowSize("/student/list-all");

        messageModel.waitUntilWebElementIsVisible("xpath", "//*[@id='root']/p");

        Assertions.assertEquals("You are not authorized to see this webpage!", messageModel.getNotAuthorizedMsg());
    }

    private void getOwnProfile() {
        messageModel.openUrlWithSpecificPathAndMaximizeWindowSize("/student/list-all");
        messageModel.waitUntilWebElementIsVisible("className", "AllStudentHeader");

        messageModel.clickOnOwnProfile();
        messageModel.waitUntilWebElementIsVisible("xpath", "//h1[text() = 'My profile:']");
    }
}
