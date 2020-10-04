package stepDefinitions.theInternet;

import io.cucumber.java.en.Then;
import pageObjects.theInternet.SecureAreaPage;

public class SecureAreaSteps {
    SecureAreaPage secureArea;

    public SecureAreaSteps() {
        secureArea = new SecureAreaPage();
    }

    @Then("the success message should display within secure area page")
    public void theSuccessMessageShouldDisplayWithinSecureAreaPage() {
        secureArea.successMessagePresent();
    }

}
