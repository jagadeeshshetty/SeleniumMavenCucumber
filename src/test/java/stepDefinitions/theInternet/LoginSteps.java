package stepDefinitions.theInternet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.theInternet.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = null;
    LoginPage login;

    @Given("i open {string} product {string} page")
    public void iOpenProductPage(String productName, String pageName) {
        File driverLocation;
        if (System.getProperty("os.name").contains("Mac OS X"))
            driverLocation = new File(new File("drivers"), "chromedriver");
        else
            driverLocation = new File("src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverLocation.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(48, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        login = new LoginPage(driver);
        driver.navigate().to(login.URL);
    }

    @Then("the page should open with {string} title")
    public void thePageShouldOpenWithTitle(String title) {
        driver.getTitle().equals(title);
    }

    @When("i login with {string} username and {string} password")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        login.authenticate(username, password);
    }

}
