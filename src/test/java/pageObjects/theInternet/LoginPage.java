package pageObjects.theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public String URL = "http://the-internet.herokuapp.com/login";
    WebDriver driver;
    @FindBy(id = "username")
    WebElement USERNAME_INPUT;
    @FindBy(id = "password")
    WebElement PASSWORD_INPUT;
    @FindBy(css = "button")
    WebElement SUBMIT_BUTTON;
    @FindBy(css = ".flash.success")
    WebElement SUCCESS_MESSAGE;
    @FindBy(css = ".flash.error")
    WebElement FAILURE_MESSAGE;
    @FindBy(id = "login")
    WebElement LOGIN_FORM;
    private String TITLE = "The Internet";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void authenticate(String username, String password) {
        USERNAME_INPUT.sendKeys(username);
        PASSWORD_INPUT.sendKeys(password);
        SUBMIT_BUTTON.click();
    }
}
