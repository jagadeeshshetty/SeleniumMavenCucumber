import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        strict = true,
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/html-report",
                "json:target/json-report/json-report.json",
                "junit:target/junit-report/xml-report.xml"
        },
        tags = "@failScenarios"
)
public class TestRunner {
}
