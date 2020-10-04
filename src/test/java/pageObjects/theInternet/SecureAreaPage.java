package pageObjects.theInternet;

import org.openqa.selenium.By;
import pageObjects.BasePage;

public class SecureAreaPage extends BasePage {
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");

    public Boolean successMessagePresent() {
        return isDisplayed(successMessageLocator);
    }
}
