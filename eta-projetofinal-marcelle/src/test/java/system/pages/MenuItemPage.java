package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import java.util.List;

public class MenuItemPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By dialog = By.cssSelector("div [role=dialog]");
    private By itemTitle = By.cssSelector("[role=dialog] > div:nth-child(4) > div h1");
    private By itemDescription = By.cssSelector("[role=dialog] > div:nth-child(4) > div > div:last-child");
    private By itemPrice = By.cssSelector("[role=dialog] > div:nth-child(4) > div:last-child button div:last-child");
    private By addToCartButton = By.cssSelector("[role=dialog] > div:nth-child(4) > div:last-child button div:nth-child(2)");
    private By plusButton = By.cssSelector("[role=dialog] > div:nth-child(4) > div:last-child div button:last-of-type");
    private By menuList = By.cssSelector("#main-content > div > ul > li > ul > li");

    public MenuItemPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public String getItemTitle() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemTitle));
        } catch (Exception e) {
        }
        return driver.findElement(itemTitle).getText();
    }

    public String getItemDescription() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemDescription));
        } catch (Exception e) {
        }
        return driver.findElement(itemDescription).getText();
    }

    public String getItemPrice() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemDescription));
        } catch (Exception e) {
        }
        return driver.findElement(itemPrice).getText();
    }

    public void openMenuItem(String targetItemTitle) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(menuList));
            findMenuItem(targetItemTitle).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(dialog));
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemDescription));
        } catch (Exception e) {
        }
    }

    private WebElement findMenuItem (String targetItemTitle) {
        List<WebElement> menuItems = driver.findElements(menuList);
        String[] itemDetails;

        for (WebElement item : menuItems) {
            itemDetails = item.getText().split("\\n");
            String currentItem = itemDetails[0].toUpperCase().trim();
            if (currentItem.equals(targetItemTitle)) {
                return item;
            }
        }
        return null;
    }

    public void addItemToCart(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
            driver.findElement(addToCartButton).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(dialog));
        } catch (Exception e) {
        }
    }

    public void increaseQuantity(int qty){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(plusButton));
            for(int i = 0; i < qty-1; i++) {
                driver.findElement(plusButton).click();
            }
        } catch (Exception e) {
        }
    }

}
