package pageObjects;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private static final Logger logger = LoggerHelper.getLogger(BasePage.class);
    private WebDriver driver;

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void visit(String url) {
        driver.get(url);
        logger.info("'" + url + "' URL");
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
        logger.info("on '" + locator + "' locator");
    }

    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
        logger.info("'" + inputText + "' into '" + locator + "' locator");
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.error("Element '" + find(locator) + "' Not Present.");
            logger.error(exception);
            return false;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
