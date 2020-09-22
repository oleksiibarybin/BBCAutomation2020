package com.bbc.ta.pages;

import com.bbc.ta.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    protected static final String BASE_URL = "https://www.bbc.com";

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
