package system.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import system.pages.MainPage;

public class SearchRestaurantsSteps {

    MainPage mainPage = new MainPage();

    @Given("User is in Uber Eats main page without a location set")
    public void accessMainPage() {
        mainPage.accessPage();
    }
    @When("User fill in location field with {string}")
    public void fillInLocation(String location) throws InterruptedException {
        mainPage.fillInAddress(location);
        Thread.sleep(2500);
    }
    @When("User clicks on Search button")
    public void clickOnSearch() {
        mainPage.clickSearch();
    }

    @Then("The location is set to {string}")
    public void validateLocationIsSet(String locationSet) {
        Assert.assertEquals(locationSet, mainPage.getSelectedLocation());
    }

    @Then("List of restaurants are displayed")
    public void listOfRestaurantsDisplayed() {
        Assert.assertTrue(mainPage.isListOfRestaurantsVisible());
    }

}
