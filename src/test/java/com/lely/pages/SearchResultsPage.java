package com.lely.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(className = ".item-with-image']")
    public List<WebElement> searchResults;


}
