package pageObjects.theInternet;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerHelper.getLogger(LoginPage.class);
    public String URL = "http://the-internet.herokuapp.com/login";
    private String TITLE = "The Internet";
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButton = By.cssSelector("button");
    By loginFormLocator = By.id("login");

    public LoginPage(WebDriver driver) {
        super();
    }

    public void authenticate(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);
    }

}
