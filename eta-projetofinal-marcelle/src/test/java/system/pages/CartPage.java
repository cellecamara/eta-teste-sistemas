package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By popover = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child");
    private By restaurantName = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child > div a span");
    private By itemsList = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child > div ul li");
    private By itemTitle = By.cssSelector("a > div > div > div:nth-child(1)");
    private By itemCost = By.cssSelector("a > div > div > div:nth-child(3)");
    private By itemQty = By.cssSelector("div > div > select");
    private By totalCost = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child > div > div:nth-child(3) > div:last-child a div:last-child");
    private By totalQtyItems = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child > div > div:nth-child(3) > div:last-child a div:first-child");
    private By closeButton = By.cssSelector("#wrapper > header > div:nth-child(2) > div > div:nth-child(8) > div:last-child > div button");

    public CartPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public boolean isVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(popover));
            return driver.findElement(popover).isDisplayed();
        } catch (Exception e) {
        }
        return false;
    }

    public void close() {
        try {
            driver.findElement(closeButton).click();
        } catch (Exception e) {

        }
    }

    public String getRestaurantName(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantName));
        } catch (Exception e) {
        }
        return driver.findElement(restaurantName).getText();
    }

    public String getTotalCost(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(totalCost));
        } catch (Exception e) {
        }
        return driver.findElement(totalCost).getText();
    }

    public int getTotalQtyItems(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(totalQtyItems));
        } catch (Exception e) {
        }
        return Integer.parseInt(driver.findElement(totalQtyItems).getText());
    }

    public int getAmountOfItems(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemsList));
        } catch (Exception e) {
        }
        List<WebElement> menuItems = driver.findElements(itemsList);
        return menuItems.size();
    }

    public List<String> getItemsInCart() {
        List<String> list = new ArrayList<String>();
        String title,cost,qty;
        String combined;
        Select select;

        try {
            Thread.sleep(2500);
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemsList));
            List<WebElement> orderItems = driver.findElements(itemsList);

            int i = 0;
            for (WebElement item : orderItems) {
                title = item.findElement(itemTitle).getText();
                cost = item.findElement(itemCost).getText();

                select = new Select(item.findElement(itemQty));
                WebElement option = select.getFirstSelectedOption();
                qty = option.getText();
                combined = qty+title+cost;
                list.add(combined);
            }

        } catch (Exception e) {
        }
        return list;
    }
}