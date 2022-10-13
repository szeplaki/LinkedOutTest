package org.example.Model;

import org.example.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MessageModel extends StudentPageModel {

    @FindBy(id = "subject")
    private WebElement subjectField;
    @FindBy(id = "from")
    private WebElement fromField;
    @FindBy(id = "message")
    private WebElement messageField;
    @FindBy(id = "send-message-btn")
    private WebElement sendMessageButton;

    public MessageModel() {
    }

    public void clickOnOwnProfile() {
        webDriver.findElement(By.xpath("//div[@class='student-list-con']//a//p[@class='studentName' and text()='"
                + FileReader.getValueByKeyFromConfigProperties("linkedout.username") + "']")).click();
    }

    public void clickOnSendMessage() {
        webDriver.findElement(By.xpath("//div[@class='prof-links']/a[contains(@id, 'inbox-send')]")).click();
    }

    public void sendMessage(String subject, String from, String message) {
        subjectField.sendKeys(subject);
        fromField.sendKeys(from);
        messageField.sendKeys(message);

        sendMessageButton.click();
    }

    public void clickOnInbox() {
        webDriver.findElement(By.xpath("//div[@class='prof-links']/a[contains(@id, 'inbox-receive')]")).click();
    }

    public boolean sentMessageFound(String subject, String from, String message) {
        List<String> listOfElements = webDriver.findElements(By.xpath("//div[@class='message-info']/p")).stream().map(WebElement::getText).collect(Collectors.toList());

        return listOfElements.contains(subject) && listOfElements.contains(from) && listOfElements.contains(message);
    }
}
