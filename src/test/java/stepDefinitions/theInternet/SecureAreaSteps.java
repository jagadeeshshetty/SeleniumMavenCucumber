package stepDefinitions.theInternet;

import io.cucumber.java.en.Then;
import pageObjects.theInternet.SecureAreaPage;

public class SecureAreaSteps {

    LoginSteps loginSteps = new LoginSteps();
    SecureAreaPage secureArea = new SecureAreaPage(loginSteps.driver);

    @Then("the success message should display within secure area page")
    public void theSuccessMessageShouldDisplayWithinSecureAreaPage() {

    }
}
