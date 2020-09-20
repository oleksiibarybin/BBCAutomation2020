package com.bbc.ta.pages.common;

import com.bbc.ta.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainHorizontalMenu extends HomePage {
    @FindBy(id = "orb-search-q")
    private WebElement inputSearch;

    @FindBy(id = "orb-search-button")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@id='orb-header']//li[@class='orb-nav-newsdotcom']//a")
    private WebElement linkNewsCategory;

    public MainHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public WebElement getMainMenuCategory(String category) {
        switch (category) {
            case "news": {
                return linkNewsCategory;
            }
        }
        return null;
    }
}
