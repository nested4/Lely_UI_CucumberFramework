package com.lely.step_definitions;

import com.lely.pages.HomePage;
import com.lely.pages.SearchResultsPage;
import com.lely.utilities.BrowserUtils;
import com.lely.utilities.ConfigurationReader;
import com.lely.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchFunctionality_StepDefinitions {
    SearchResultsPage searchResultsPage= new SearchResultsPage();
    HomePage homePage= new HomePage();
    @Given("User is on the Lely website")
    public void user_is_on_the_lely_website() {
        homePage.navigateToHomePage();
        homePage.acceptCookies();
    }
    @When("User clicks the search button")
    public void user_clicks_the_search_button() {
        homePage.searchButtonHeader.click();

    }
    @Then("the search area should appear")
    public void the_search_area_should_appear() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.searchArea.isDisplayed());
    }
    @When("User enters {string} into the search area and click the search button")
    public void user_enters_into_the_search_area_and_click_the_search_button(String keyword) {
        homePage.searchArea.sendKeys(keyword);
        BrowserUtils.waitFor(1);
        homePage.searchButton.click();
    }
    @Then("all search results should contain the keyword {string}")
    public void all_search_results_should_contain_the_keyword(String string) {
//        System.out.println("searchResultsPage.searchResults.size() = " + searchResultsPage.searchResults.size());
    }

}
