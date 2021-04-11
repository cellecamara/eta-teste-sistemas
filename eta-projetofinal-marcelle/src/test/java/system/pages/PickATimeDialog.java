package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class PickATimeDialog {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dialog = By.cssSelector("[role=dialog]");
    private By scheduleButton = By.cssSelector("[role=dialog] > div:nth-child(3) > button:first-of-type");
    private By timeSelect = By.cssSelector("[role=dialog] > div:nth-child(3) > div:nth-child(4) select");


    public PickATimeDialog() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void setTime(String deliveryTime){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(timeSelect));
            Select select = new Select(driver.findElement(timeSelect));
            try {
                select.selectByVisibleText(deliveryTime);
            } catch (NoSuchElementException e){
                //In case of a time not available to schedule, Keep going and click on Schedule button
            }
            clickSchedule();
        } catch (Exception e) {
        }
    }

    public void clickSchedule(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(scheduleButton));
            driver.findElement(scheduleButton).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
