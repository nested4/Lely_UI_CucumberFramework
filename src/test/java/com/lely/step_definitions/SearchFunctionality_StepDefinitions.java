package com.lely.step_definitions;

import com.lely.pages.HomePage;
import com.lely.pages.SearchResultsPage;
import com.lely.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SearchFunctionality_StepDefinitions {
    SearchResultsPage searchResultsPage= new SearchResultsPage();
    HomePage homePage= new HomePage();
    @Given("user is on the Lely website")
    public void user_is_on_the_lely_website() {
        //navigate to home page
        homePage.navigateToHomePage();
        //accept cookies
        homePage.acceptCookies();

    }
    @When("user clicks the search button")
    public void user_clicks_the_search_button() {
        //click search button on the header
        homePage.searchButtonHeader.click();

    }
    @Then("the search area should appear")
    public void the_search_area_should_appear() {
        //verify the search area is appeared.
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.searchArea.isDisplayed());
    }
    @When("user enters {string} into the search area and click the search button")
    public void user_enters_into_the_search_area_and_click_the_search_button(String keyword) {
        //Enter “keyword” into the search area and click the search button.
        homePage.searchArea.sendKeys(keyword);
        BrowserUtils.waitFor(1);
        homePage.searchButton.click();
    }

    @Then("all search results should contain the keyword {string}")
    public void all_search_results_should_contain_the_keyword(String keyword) {
        System.out.println(searchResultsPage.doSearchResultsContainKeyword(keyword));
    }

}
