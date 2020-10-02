package stepDefinitions.selenium4;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeDevTools {
    WebDriver driver = null;

    @Given("test chrome dev tools")
    @Test
    public void testChromeDevTools() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("85").arch64().setup();
//        WebDriverManager.chromedriver().driverVersion("85").arch64().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(48, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();

        devTools.createSession();
        devTools.send(Log.enable());

        devTools.addListener(Log.entryAdded(), entry -> {
            System.out.println(entry.getText());
        });

//        driver.get("https://nhnb.github.io/console-log/console-log/demo.html");

//        devTools.addListener(Log.entryAdded(), entry -> {
//            System.out.println(entry.getText());
//        });
//        driver.get("https://devtools.glitch.me/console/log.html");

        List<String> list = new ArrayList<String>();

        devTools.addListener(Log.entryAdded(), entry -> {
            list.add(entry.getText());
        });


        driver.get("https://devtools.glitch.me/console/log.html");
        Thread.sleep(2000);
        // Log Info
        driver.findElement(By.id("hello")).click();
        Thread.sleep(2000);
        // Log Warning
        driver.findElement(By.id("dante")).click();
        Thread.sleep(2000);
        // Log Error
        driver.findElement(By.id("hal")).click();
        Thread.sleep(2000);
        // Log Table
        driver.findElement(By.id("table")).click();
        Thread.sleep(2000);
        // Log Group
        driver.findElement(By.id("group")).click();
        Thread.sleep(2000);
        // Log Custom
        driver.findElement(By.id("custom")).click();
        Thread.sleep(2000);
        // Cause 404
        driver.findElement(By.id("network")).click();
        Thread.sleep(2000);
        // Cause Error
        driver.findElement(By.id("error")).click();
        Thread.sleep(2000);
        // Cause Violation
        driver.findElement(By.id("violation")).click();
        Thread.sleep(2000);

        for (Object log : list) {
            System.out.println("[CONSOLE LOG] " + log);
        }

        driver.close();
        driver.quit();
    }
}
