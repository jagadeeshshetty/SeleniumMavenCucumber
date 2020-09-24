package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeDevTools {
    ChromeDriver driver = null;

    @Given("test chrome dev tools")
    @Test
    public void testChromeDevTools() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("85").arch64().setup();
        WebDriverManager.chromedriver().driverVersion("85").arch64().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(48, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        DevTools devTools =  driver.getDevTools();

        devTools.createSession();
        devTools.send(Log.enable());

        List<String> list = new ArrayList<String>();

        devTools.addListener(Log.entryAdded(), entry -> {
            list.add(entry.getText());
        });

        driver.get("http://the-internet.herokuapp.com/login");
        for (Object log:list) {
            System.out.println("[CONSOLE LOG]" + log);
        }

        driver.close();
        driver.quit();
    }
}
