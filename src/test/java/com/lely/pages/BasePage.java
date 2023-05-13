package com.lely.pages;

import com.lely.utilities.ConfigurationReader;
import com.lely.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class=\"header-navigation-button__label\" and .=\"Search\"]")
    public WebElement searchButtonHeader;

    @FindBy(id = "global-search")
    public WebElement searchArea;

    @FindBy(xpath = "//button[@type=\"submit\" and .=\"Search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@id=\"cookienotice-button-accept\"]")
    public WebElement acceptCookiesButton;

    public void navigateToHomePage() {
        String url = ConfigurationReader.get("url_homepage");
        Driver.getDriver().get(url);
    }

    public void navigateToTechDocsPage() {
        String url = ConfigurationReader.get("url_techdocs");
        Driver.getDriver().get(url);
    }

    public void acceptCookies() {
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    public void switchToMainTab() {
        String mainTab = Driver.getDriver().getWindowHandles().iterator().next();
        Driver.getDriver().switchTo().window(mainTab);
    }


}
