package com.bbc.ta.pages;

import com.bbc.ta.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openBbcWebSite() {
        driver.get("https://www.bbc.com");
    }
}
