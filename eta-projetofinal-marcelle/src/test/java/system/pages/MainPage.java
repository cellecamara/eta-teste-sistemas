package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

import static system.pages.URL.MAIN_PAGE;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By locationField = By.id("location-typeahead-home-input");
    private By searchButton = By.cssSelector("#main-content > div > div > div > div > button");
    private By selectedLocation = By.cssSelector("#wrapper > header > div > div > a:last-of-type > div:nth-child(3)");
    private By deliveryInfoButton = By.cssSelector("#wrapper > header > div > div > a:last-of-type");
    private By restaurantsList = By.cssSelector("#main-content > div > div:last-child > div:last-child");
    private DeliveryDetailsDialog deliveryDialog;

    public MainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void accessPage() {
        driver.get(MAIN_PAGE);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        } catch (Exception e) {
        }
    }

    public String getSelectedLocation(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectedLocation));
        } catch (Exception e) {
        }
        WebElement location = driver.findElement(selectedLocation);
        return location.getText();

    }
    
    public void fillInAddress(String local){
        driver.findElement(locationField).sendKeys(local,Keys.ENTER);
    }

    public boolean isListOfRestaurantsVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantsList));
        } catch (Exception e) {
        }
        return driver.findElement(restaurantsList).isDisplayed();
    }

    public void clickSearch(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            driver.findElement(searchButton).click();
        } catch (Exception e) {
        }
    }

    public void scheduleDelivery(String deliveryTime){
        deliveryDialog = new DeliveryDetailsDialog();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryInfoButton));
            driver.findElement(deliveryInfoButton).click();
            if (deliveryDialog.isVisible()){
                deliveryDialog.clickSchedule(deliveryTime);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
