package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import system.pages.AddressDialogPage;
import system.pages.CartPage;
import system.pages.MainPage;
import system.pages.RestaurantPage;
import java.util.List;

import static system.pages.URL.CASA_DE_NOCA_PAGE;

public class RestaurantMenuItemSteps {
    RestaurantPage restPage = new RestaurantPage();
    AddressDialogPage addressDialogPage = new AddressDialogPage();
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Given("User is {string} restaurant page with location set to {string}")
    public void openRestaurantPageAndSetLocation(String url, String location) {
        restPage.accessRestaurantPage(CASA_DE_NOCA_PAGE);
        try {
            addressDialogPage.fillInAddress(location);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("User clicks on menu item {string}")
    public void clickOnMenuItem(String menuItem) {
        if (cartPage.isVisible()){
            cartPage.close();}
        restPage.getMenuItemPage().openMenuItem(menuItem.toUpperCase());
    }

    @Then("The item title is {string}")
    public void validateMenuItemTitle(String expectedTitle) {
        String currentTitle = restPage.getMenuItemPage().getItemTitle().toUpperCase();
        Assert.assertEquals(expectedTitle.toUpperCase(), currentTitle);
    }

    @Then("The item description is {string}")
    public void validateMenuItemDescription(String expectedDescription)  {
        String currentDescription = restPage.getMenuItemPage().getItemDescription().toUpperCase();
        Assert.assertEquals(expectedDescription.toUpperCase(),currentDescription);
    }

    @Then("The item price is {string}")
    public void validateMenuItemPrice(String expectedPrice)  {
        String currentPrice = restPage.getMenuItemPage().getItemPrice().toUpperCase();
        Assert.assertEquals(expectedPrice.toUpperCase(),currentPrice);
    }

    @Given("User schedules the delivery to {string}")
    public void scheduleTheDelivery(String deliveryTime) {
        mainPage.scheduleDelivery(deliveryTime);
    }

    @When("User clicks on add to cart button")
    public void addToCart() {
        restPage.getMenuItemPage().addItemToCart();
    }

    @When("User increases quantity to {int}")
    public void increaseQuantity(Integer qty) {
        restPage.getMenuItemPage().increaseQuantity(qty);
    }

    @Then("Item cart popover is displayed")
    public void cartPopoverIsDisplayed() {
        Assert.assertTrue(cartPage.isVisible());
    }

    @Then("The restaurant name is {string}")
    public void validateRestaurantNameinCart(String expectedName)  {
        String currentName =  cartPage.getRestaurantName().toUpperCase();
        Assert.assertEquals(expectedName.toUpperCase(),currentName);
    }

    @Then("The total cost is {string}")
    public void validateTotalCostInCart(String expectedCost) {
        String currentCost =  cartPage.getTotalCost();
        Assert.assertEquals(expectedCost.toUpperCase(),currentCost);
    }

    @Then("There is/are {int} item(s) in cart")
    public void validateAmountOfItemsInCart(int expectedQty) {
        Assert.assertEquals(expectedQty, cartPage.getAmountOfItems());
    }

    @Given("The total quantity of items in cart is {int}")
    public void validateTotalQuantityOfItemsInCart(int expectedQty) {
        Assert.assertEquals(expectedQty, cartPage.getTotalQtyItems());
    }

    @Given("Validate list of products in cart")
    public void validateListOfProductsInCart(DataTable dataTable) {
        List<String> currentList;
        currentList = cartPage.getItemsInCart();
        List<String> expectedList = dataTable.asList();
        Assert.assertTrue(currentList.equals(expectedList));
    }
}
