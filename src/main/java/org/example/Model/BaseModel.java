package org.example.Model;

import org.example.FileReader;
import org.example.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseModel {
    protected final WebDriver webDriver;
    protected final WebDriverWait driverWait;

    @FindBy(xpath = "//*[@id='root']//form/input[@type='text']")
    protected WebElement usernameField;
    @FindBy(xpath = "//*[@id='root']//form/input[@type='password']")
    protected WebElement passwordField;
    @FindBy(id = "login-btn")
    protected WebElement loginButton;
    @FindBy(id = "logout")
    protected WebElement logoutButton;

    public BaseModel() {
        this.webDriver = WebDriverService.getInstance().getWebDriver();
        driverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(webDriver, this);
    }

    protected void setUsername(String username) {
        this.usernameField.sendKeys(username);
    }

    protected void setPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    protected void clickOnLoginButton() {
        loginButton.click();
    }

    /**
     * The webDriver waits until the selected webElement is visible, or 15 sec. maximum duration.
     *
     * @param type the type of the element you are looking for: id, xpath, css or className.
     * @param id   the selected element's selector.
     */
    public void waitUntilWebElementIsVisible(String type, String id) {
        switch (type) {
            case "id":
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
            case "xpath":
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id)));
                break;
            case "css":
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(id)));
                break;
            case "className":
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(id)));
                break;
        }
    }

    /**
     * The webDriver waits until the selected webElement is clickable, or 15 sec. maximum duration.
     *
     * @param type type the type of the element you are looking for: id, xpath, css or className.
     * @param id   the selected element's selector.
     */
    public void waitUntilWebElementIsClickable(String type, String id) {
        switch (type) {
            case "id":
                driverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
                break;
            case "xpath":
                driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(id)));
                break;
            case "css":
                driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(id)));
                break;
            case "className":
                driverWait.until(ExpectedConditions.elementToBeClickable(By.className(id)));
                break;
        }
    }

    public void doLogin() {
        webDriver.navigate().to(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl") + "/login");
        webDriver.manage().window().maximize();

        setUsername(FileReader.getValueByKeyFromConfigProperties("linkedout.username"));
        setPassword(FileReader.getValueByKeyFromConfigProperties("linkedout.password"));
        clickOnLoginButton();
        waitUntilWebElementIsVisible("xpath", "//h2[text() = 'LnkdOut']");
    }

    public void openUrlWithSpecificPathAndMaximizeWindowSize(String path) {
        webDriver.get(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl") + path);
        webDriver.manage().window().maximize();
    }

    public void waitUntilLoggedIn() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-details-user-fullname")));
    }

    public void getLoginPage() {
        webDriver.get(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl") + "/login");
        waitUntilWebElementIsClickable("id", "login-btn");
    }

    public void openBaseUrl(){
        webDriver.get(FileReader.getValueByKeyFromConfigProperties("linkedout.baseurl"));
    }
}
