package stepDefinitions.theInternet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.theInternet.LoginPage;
import utils.Hooks;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends Hooks {
    private LoginPage login;

    public void setUp() {
        login = new LoginPage(driver);
    }

    @Given("i open {string} product {string} page")
    public void iOpenProductPage(String productName, String pageName) {
        login.visit(login.URL);
    }

    @Then("the page should open with {string} title")
    public void thePageShouldOpenWithTitle(String title) {
        assertEquals(title, login.getTitle());
    }

    @When("i login with {string} username and {string} password")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        login.authenticate(username, password);
    }

}
