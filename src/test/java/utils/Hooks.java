package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePage;

import java.util.concurrent.TimeUnit;

/**
 * Hooks are the methods which are automatically invoked by cucumber framework.<p>
 * Two types of Hooks which executes before and after the scenario.<p>
 * 1. Before<p>
 * 2. After<p>
 * To use hooks, add class path to the Runner.class (same as step definition).<p>
 * API Ref:  https://javadoc.io/doc/io.cucumber/cucumber-java/latest/io/cucumber/java/package-summary.html
 */
public class Hooks {
    /**
     * Steps:<p>
     * 1. Create the public method.<p>
     * 2. Use the @Before and @After annotations.<p>
     * 3. Specify the package in the runner.<p>
     * 4. [Optional] To get the run time info about the scenario which is being executed,
     * inject the Scenario Object in the hook method.
     */
    public static WebDriver driver;
    private BasePage basePage;

    @Before
    public void before(Scenario name) {
        System.out.printf(">>>>>>>>>>>> [TEST START] " + "<<<<<<<<<<<<\n");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("85").arch64().setup();
        // WebDriverManager.chromedriver().driverVersion("85").arch64().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(48, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        basePage = new BasePage();
        basePage.setWebDriver(driver);
    }

    @After
    public void after(Scenario scenario) {
        System.out.printf(">>>>>>>>>>>> [TEST COMPLETE] [STATUS] " + scenario.getStatus() + " <<<<<<<<<<<<\n");
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.close();
        driver.quit();
    }
}
