package org.example.Model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentPageModel extends BaseModel {

    @FindBy(xpath = "//*[@id='root']/p")
    private WebElement notAuthorizedMsg;
    @FindBy(className = "AllStudentHeader")
    private WebElement studentPageHeader;

    public String getNotAuthorizedMsg() {
        return this.notAuthorizedMsg.getText();
    }

    public String getStudentHeaderText() {
        return this.studentPageHeader.getText();
    }
}
