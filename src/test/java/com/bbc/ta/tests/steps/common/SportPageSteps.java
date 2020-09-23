package com.bbc.ta.tests.steps.common;

import io.cucumber.java.en.When;

public class SportPageSteps {

    @When("user clicks on {string} category in sport page horizontal menu")
    public void clickOnSportPageHorizontalMenuCategory(String category) {
        PageFactory
                .getSportHorizontalMenu()
                .clickOnMenuCategoryInSportPageMenu(category);
    }

    @When("user clicks on {string} category in sport page football horizontal menu")
    public void clickOnSportPageFootballHorizontalMenuCategory(String category) {
        PageFactory
                .getFootballHorizontalMenu()
                .clickOnMenuCategoryInSportPageFootballMenu(category);
    }

    @When("user enters {string} to search field")
    public void setValueToInpbtSearchFieldFootballPage(String query) {
        PageFactory
                .getFootballPage()
                .setInputSearchFieldFootballPage(query);
    }

    @When("user select first result below search field")
    public void selectFirstResultBelowSearchField() {
        PageFactory
                .getFootballPage()
                .clickOnFirstSearchResultBelowSearchField();
    }

    @When("user select first month results in league current season")
    public void clickOnFirstMonthResultsInLeagueCurrentSeason() {
        PageFactory
                .getFootballPage()
                .clickOnLinkLeagueFirstSeasonMonthResults();
    }
}
