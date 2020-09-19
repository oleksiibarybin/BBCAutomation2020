package com.bbc.ta.pages.common;

import com.bbc.ta.pages.HomePage;
import com.bbc.ta.pages.SearchResultsPage;
import com.bbc.ta.pages.news_page.NewsPage;
import org.openqa.selenium.Keys;
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

    public SearchResultsPage findTextBySearch(String text) {
        setInputSearch(text);
        return new SearchResultsPage(driver);
    }

    public WebElement menuCategory(String category) {
        switch (category) {
            case "news": {
                return linkNewsCategory;
            }
        }
        return null;
    }

    public NewsPage clickOnNewsPageLink() {
        waitForElementVisibility(linkNewsCategory);
        linkNewsCategory.click();
        return new NewsPage(driver);
    }

    public void clickOnNewsPage() {
        waitForElementVisibility(linkNewsCategory);
        linkNewsCategory.click();
    }

    public void setInputSearch(String text) {
        inputSearch.sendKeys(text, Keys.ENTER);
    }
}
