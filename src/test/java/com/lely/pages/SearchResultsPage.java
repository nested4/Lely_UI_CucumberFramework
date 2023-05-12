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

//    @FindBy(css = ".page-next")
//    public  WebElement nextButton;

    public List<String> doSearchResultsContainKeyword(String keyword) {
        List<String> results = new ArrayList<>();
        boolean isNextPageButtonEnabled;

        do {
            for (WebElement searchResult : searchResults) {
                String description = searchResult.getText().toLowerCase();
                try {
                    Assert.assertTrue("Search result description should contain the keyword: " + keyword,
                            description.contains(keyword));
                    results.add("\nPASS: " + description);
                } catch (AssertionError e) {
                    results.add("\nFAIL: " + description);
                }
            }

            isNextPageButtonEnabled = !nextButton.getAttribute("class").contains("disabled");

            if (isNextPageButtonEnabled) {
                nextButton.click();
            }
        } while (isNextPageButtonEnabled);
        return results;
    }


}
