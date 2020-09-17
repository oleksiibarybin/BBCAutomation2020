package com.bbc.ta.pages.news_page;

import com.bbc.ta.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends AbstractPage {

    private final String BASE_URL = "https://www.bbc.com/news";

    @FindBy(xpath = "//h3[contains(@class,'gel-paragon-bold')]")
    private WebElement textNewsHeadLineTitle;

    @FindBy(xpath = "//h3[contains(@class,'gel-pica-bold')]")
    private List<WebElement> textSecondaryTitles;

    @FindBy(xpath = "//a[@aria-label]/span")
    private WebElement textNewsHeadLineLocationCategory;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#2']")
    private WebElement blockFirstSecondaryNews;


    public NewsPage (WebDriver driver) {
        super(driver);
    }

    public String getTextNewsHeadLineTitle() {
        waitForElementVisibility(textNewsHeadLineTitle);
        return textNewsHeadLineTitle.getText();
    }

    public List<String> getTextForFirstSixSecondaryTitles() {
        waitForElementVisibility(blockFirstSecondaryNews);
        List<String> secondaryTitlesText = new ArrayList<String>();
        for (int i = 0; i < 6; i++)
            secondaryTitlesText.add(textSecondaryTitles.get(i).getText());
        return secondaryTitlesText;
    }

    public String getTextNewsHeadLineLocationCategory(){
        waitForElementVisibility(textNewsHeadLineLocationCategory);
        return textNewsHeadLineLocationCategory.getText();
    }


}
