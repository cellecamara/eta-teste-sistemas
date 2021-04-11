package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class DeliveryDetailsDialog {
    private WebDriver driver;
    private WebDriverWait wait;

    private PickATimeDialog pickATimeDialog = new PickATimeDialog();
    private By dialog = By.cssSelector("[role=dialog]");
    private By scheduleButton = By.cssSelector("#wrapper > div:nth-child(8) > div > div > div> div > div > div > div:nth-child(2) > div > a");
    private By doneButton = By.cssSelector("[role=dialog] > div > button:nth-child(3)");

    public DeliveryDetailsDialog() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void clickDone(){
        driver.findElement(doneButton).click();
    }

    public void clickSchedule(String deliveryTime){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(scheduleButton));
            driver.findElement(scheduleButton).click();
            pickATimeDialog.setTime(deliveryTime);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dialog));
            return driver.findElement(dialog).isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
