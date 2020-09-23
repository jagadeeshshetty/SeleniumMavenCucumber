package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.GoogleSearchPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null;
    GoogleSearchPage googlePage;

    @Given("i open google search page")
    public void iOpenGoogleSearchPage() {
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
        googlePage = new GoogleSearchPage(driver);
        driver.navigate().to(googlePage.url);
    }

    @When("i enter {string} entry into searchEditBox element")
    public void iEnterEntryIntoElement(String entry) {
        googlePage.enterEntryToSearchBox(entry);
    }

    @And("i press {string} key into searchEditBox element")
    public void iPressKeyIntoSearchEditBoxElement(String key) throws InterruptedException {
        googlePage.pressEnterKeyInToSearchEditBox();
    }

    @Then("the new page should contain {string} entry")
    public void theNewPageShouldContainEntry(String arg0) {
        driver.getPageSource().contains("Steve Jobs - Wikipedia");
        driver.close();
        driver.quit();
    }
}
