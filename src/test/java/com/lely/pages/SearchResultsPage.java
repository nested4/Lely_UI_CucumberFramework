package com.lely.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//p[@class='item-description']/..")
    public List<WebElement> searchResults;

    @FindBy(css = ".page-next .page-link")
    public WebElement nextButton;

    /**
     * doSearchResultsContainKeyword method verifies that each  description
     * of the search results contains the searched keyword
     * Since Lely website search is also bringing some results that does NOT contain the
     * keyword in the describtion, this method is also returning a List of Strings showing
     * results as Passed and Failed with the search descriptions
     *
     * @param keyword
     * @return
     */
    public List<String> doSearchResultsContainKeyword(String keyword) {
        List<String> results = new ArrayList<>();
        //if the search results are in more than one page
        boolean isNextPageButtonEnabled;

        do {
            // searchResults is a List of Webelements need a loop to check them one by one
            for (WebElement searchResult : searchResults) {
                //get the description of the searchResult in lowercase
                String description = searchResult.getText().toLowerCase();
                try {
                    //Since some of the assertions fail we need try catch
                    Assert.assertTrue("Search result description should contain the keyword: " + keyword,
                            description.contains(keyword));
                    results.add("\nPASS: \n" + description);
                } catch (AssertionError e) {
                    results.add("\nFAIL: \n" + description);
                }
            }

            //if the Next button is not disabled we have more results
            isNextPageButtonEnabled = !nextButton.getAttribute("class").contains("disabled");
            //click for the next page for the search results if NextPageButtonEnabled
            if (isNextPageButtonEnabled) {
                nextButton.click();
            }
        } while (isNextPageButtonEnabled);
        return results;
    }


}
