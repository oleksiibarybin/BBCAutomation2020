package com.bbc.ta.pages.sport_page;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballHorizontalMenu extends SportPage {

    @FindBy(id = "sp-nav-secondary")
    private WebElement blockFootballHorizontalMenu;

    @FindBy(xpath = "//ul[@role='menu']//a[@data-stat-link='/sport/football/scores-fixtures']")
    private WebElement scoresFixturesCategory;

    public FootballHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuCategoryInSportPageFootballMenu(String category) {
        waitForElementVisibility(blockFootballHorizontalMenu);
        switch (category) {
            case "scores-fixtures": {
                scoresFixturesCategory.click();
                break;
            }
            default: throw new NotImplementedException(String.format("Category %s is not implemented", category));
        }
    }
}
