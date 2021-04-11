package system.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class RestaurantPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private MenuItemPage menuItemPage = new MenuItemPage();

    public RestaurantPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void accessRestaurantPage(String url) {
        driver.get(url);
    }

    public MenuItemPage getMenuItemPage() {
        return menuItemPage;
    }
}
