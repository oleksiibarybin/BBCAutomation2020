package com.bbc.ta.pages.sport_page;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FootballPage extends SportPage {

    @FindBy(xpath = "//input[@name='search']")
    private WebElement inputSearchFieldFootballPage;

    @FindBy(id = "search-results")
    private WebElement blockDropDownSearchResultsFieldFootballPage;

    @FindBy(xpath = "//ul[@id='sp-timeline-past-dates']//a")
    private WebElement linkLeagueFirstSeasonMonthResults;

    @FindBy(xpath = "//div[@class='qa-match-block']")
    private WebElement blockLastDayFromMonthMatchesResults;

    @FindBy(xpath = "//span[contains(@class,'full-team-name')]")
    private List<WebElement> textCommandsNames;

    @FindBy(xpath = "//span[contains(@class,'fixture__number')]")
    private List<WebElement> textCommandsMatchScores;

    @FindBy(xpath = "//a[@class='sp-c-fixture__block-link']")
    private WebElement linkLastMatchResultsDetails;

    @FindBy(xpath = "//div[@class='football-oppm-header']")
    private WebElement blockMatchResultsDetails;


    public FootballPage(WebDriver driver) {
        super(driver);
    }

    public void setInputSearchFieldFootballPage(String value) {
        waitForElementVisibility(inputSearchFieldFootballPage);
        inputSearchFieldFootballPage.sendKeys(value, Keys.ENTER);
    }

    public void clickOnFirstSearchResultBelowSearchField() {
        waitForElementVisibility(blockDropDownSearchResultsFieldFootballPage);
        blockDropDownSearchResultsFieldFootballPage.click();
    }

    public void clickOnLinkLeagueFirstSeasonMonthResults() {
        waitForElementEnabled(linkLeagueFirstSeasonMonthResults);
        linkLeagueFirstSeasonMonthResults.click();
    }

    public List<String> getMatchResults(String page) {
        switch (page) {
            case "last_month_match":
                waitForElementVisibility(blockLastDayFromMonthMatchesResults);
                return getMatchResults();
            case "event_header":
                waitForElementVisibility(blockMatchResultsDetails);
                return getMatchResults();
            default:
                throw new NotImplementedException(String.format("Page %s is not implemented", page));
        }
    }

    public void clickOnLinkLastMatchResultsDetails() {
        linkLastMatchResultsDetails.click();
    }

    private List<String> getMatchResults() {
        List<String> matchResults = new ArrayList<>();
        matchResults.add(getTextFirstCommandName());
        matchResults.add(getTextSecondCommandName());
        matchResults.add(getTextFirstCommandsMatchScore());
        matchResults.add(getTextSecondCommandsMatchScore());
        return matchResults;
    }

    private String getTextFirstCommandName() {
        return textCommandsNames.get(0).getText();
    }

    private String getTextSecondCommandName() {
        return textCommandsNames.get(1).getText();
    }

    private String getTextFirstCommandsMatchScore() {
        return textCommandsMatchScores.get(0).getText();
    }

    private String getTextSecondCommandsMatchScore() {
        return textCommandsMatchScores.get(1).getText();
    }

}
