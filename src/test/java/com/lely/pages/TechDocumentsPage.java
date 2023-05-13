package com.lely.pages;

import com.lely.utilities.BrowserUtils;
import com.lely.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TechDocumentsPage extends BasePage {


    @FindBy(css =".select2-selection__arrow" )
    public WebElement dropdownArrow;

    @FindBy(css = ".select2-search__field")
    public WebElement searchInputBox;

    @FindBy(xpath = "//*[@class=\"result-item-title\"]")
    public List<WebElement> resultItemTitles;

    @FindBy(xpath = "((//footer[@class=\"result-item-footer\"])[1]//a)[2]")
    public  WebElement viewThisDocumentButton;

    @FindBy(xpath = "((//footer[@class=\"result-item-footer\"])[1]//a)[2]")
    public  WebElement downloadDocumentButton;

    public void selectDocFromDropdown(String documentName) {
        dropdownArrow.click();
        BrowserUtils.waitFor(1);
        searchInputBox.sendKeys(documentName+Keys.ENTER);
    }

    public boolean areCatalogsVisible() {

        BrowserUtils.scrollToElement(resultItemTitles.get(0));
        BrowserUtils.waitForVisibility(resultItemTitles.get(0),4);
        return resultItemTitles.size() > 0;

    }


}
