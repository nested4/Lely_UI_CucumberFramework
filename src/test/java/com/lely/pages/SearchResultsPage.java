package com.lely.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//p[@class='item-description']/..")
    public List<WebElement> searchResults;

    @FindBy(css = ".page-next .page-link")
    public  WebElement nextButton;

//    @FindBy(css = ".page-next")
//    public  WebElement nextButton;




}
