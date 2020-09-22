package com.bbc.ta.pages.common;

import com.bbc.ta.pages.HomePage;
import org.apache.commons.lang3.NotImplementedException;
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

    @FindBy(xpath = "//div[@id='orb-header']//li[@class='orb-nav-sport']//a")
    private WebElement linkSportCategory;


    public MainHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnMainMenuCategory(String category) {
        switch (category) {
            case "news": {
                linkNewsCategory.click();
                break;
            }
            case "sport": {
                linkSportCategory.click();
                break;
            }
            default: throw new NotImplementedException(String.format("Category %s is not implemented", category));
        }
    }
}
