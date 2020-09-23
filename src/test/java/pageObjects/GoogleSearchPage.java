package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    public String url = "https://www.google.co.in/";
    public String title = "Google";
    public By searchEditBox = By.name("q");
    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEntryToSearchBox(String entry) {
        driver.findElement(searchEditBox).sendKeys(entry);
    }

    public void pressEnterKeyInToSearchEditBox() throws InterruptedException {
        driver.findElement(searchEditBox).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
}
