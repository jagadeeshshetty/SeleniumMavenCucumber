package stepDefinitions.learn;

import io.cucumber.java.en.When;

public class LearnSteps {
    @When("I try to divide number by zero")
    public void iTryToDivideNumberByZero() {
        System.out.println("Divide 2/0" + 2 / 0);
    }

    @When("I try to divide number by zero with checked exception")
    public void iTryToDivideNumberByZeroWithCheckedException() {
        try {
            System.out.println("Divide 2/0" + 2 / 0);
        } catch (ArithmeticException e) {
            System.err.println(e);
        }
    }


}
