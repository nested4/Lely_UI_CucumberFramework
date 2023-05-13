package com.lely.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "bottom-links-container")
    public WebElement bottomLinks;


}

