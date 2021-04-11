package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class AddressDialogPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dialog = By.cssSelector("div [role=dialog]");
    private By deliveryAddressField = By.id("location-typeahead-location-manager-input");

    public AddressDialogPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void fillInAddress(String location) throws InterruptedException{
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dialog));
            driver.findElement(deliveryAddressField).click();

            driver.findElement(deliveryAddressField).sendKeys(location);
            Thread.sleep(3000);
            driver.findElement(deliveryAddressField).sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(dialog));

        } catch (Exception e) {

        }
    }

}
