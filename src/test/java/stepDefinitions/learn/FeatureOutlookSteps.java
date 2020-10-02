package stepDefinitions.learn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeatureOutlookSteps {
    @Given("A precondition")
    public void aPrecondition() {
        System.out.println("Still need to figure out a precondition!");
    }

    @Then("Validate other action")
    public void validate_other_action() {
        System.out.println("Will validate the result from a previous action.");
    }


    @Then("Validate negative action")
    public void validate_negative_action() {
        System.out.println("Additional validation with previous step.");
    }

    @When("Perform an action")
    public void perform_an_action() {
        System.out.println("Will perform an action.");
    }


    @Then("Validate the action")
    public void validate_the_action() {
        System.out.println("Will validate the result from a previous action.");
    }

}
