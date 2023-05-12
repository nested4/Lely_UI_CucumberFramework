package com.lely.pages;

import com.lely.utilities.BrowserUtils;
import com.lely.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Test {
    //Erase Before Submit SIIIILLLLL!!!!!!!!!!!!!!!!!!!!!!!!
    @org.junit.Test
    public void test1() {
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.xpath("//textarea[@id='APjFqb' and @class=\"gLFyf\"]")).sendKeys("Elma"+ Keys.ENTER);
        WebElement gooooogle = Driver.getDriver().findElement(By.cssSelector("tr[jsname='TeSSVd'] "));
        BrowserUtils.scrollToElement(gooooogle);
    }
}
