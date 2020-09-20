package com.bbc.ta.pages.news_page;

import com.bbc.ta.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends AbstractPage {

    @FindBy(xpath = "//h3[contains(@class,'gel-paragon-bold')]")
    private WebElement textNewsHeadLineTitle;

    @FindBy(xpath = "//h3[contains(@class,'gel-pica-bold')]")
    private List<WebElement> textSecondaryTitles;

    @FindBy(xpath = "//a[@aria-label]")
    private WebElement linkNewsHeadLineArticleCategory;

    @FindBy(xpath = "//a[@aria-label]/span")
    private WebElement textNewsHeadLineArticleCategory;

    @FindBy(xpath = "//div[@aria-label='Featured Contents']//a[@aria-label]/span")
    private WebElement textCategoryHeadLineArticleCategory;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#2']")
    private WebElement blockFirstSecondaryNews;


    public NewsPage(WebDriver driver) {
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

    public void clickOnLinkNewsHeadLineCategory() {
        waitForElementVisibility(linkNewsHeadLineArticleCategory);
        linkNewsHeadLineArticleCategory.click();
    }

    public String getTextNewsHeadLineArticleCategory() {
        waitForElementVisibility(textNewsHeadLineArticleCategory);
        return textNewsHeadLineArticleCategory.getText();
    }

    public String getTextCategoryHeadLineArticleCategory() {
        waitForElementVisibility(textCategoryHeadLineArticleCategory);
        return textCategoryHeadLineArticleCategory.getText();
    }
}
