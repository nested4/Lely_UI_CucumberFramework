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

    @FindBy(css = "#id_q")
    public WebElement documentDropdown;
    @FindBy (tagName = "iframe")
    public WebElement iframe;

    @FindBy(css =".select2-selection__arrow" )
    public WebElement dropdownArrow;

    @FindBy(css = ".select2-search__field")
    public WebElement searchInputBox;

    @FindBy(xpath = "//*[@class=\"result-item-title\"]")
    public List<WebElement> resultItemTitles;


    public void selectDocFromDropdown(String documentName) {
        dropdownArrow.click();
        BrowserUtils.waitForVisibility(searchInputBox,4);
        searchInputBox.sendKeys(documentName+Keys.ENTER);
//        Driver.getDriver().switchTo().frame(iframe);
//        Select select = new Select(documentDropdown);
//        select.selectByVisibleText(documentName);
    }

    public boolean areCatalogsVisible() {

        BrowserUtils.scrollToElement(resultItemTitles.get(1));
        BrowserUtils.waitForVisibility(resultItemTitles.get(1),4);
        return resultItemTitles.size() > 0;

    }


}
