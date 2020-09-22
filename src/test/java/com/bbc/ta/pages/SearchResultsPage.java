package com.bbc.ta.pages;

import com.bbc.ta.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//span[@type='category']")
    private List<WebElement> textSearchResultsCategory;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextSearchResultsCategory() {
        waitForElementVisibility(textSearchResultsCategory.get(0));
        return textSearchResultsCategory.get(1).getText();
    }
}
