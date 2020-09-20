package com.bbc.ta.tests.steps.common;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class NewsPageSteps extends BaseSteps {

    private String newsHeadLineArticleCategory;

    @When("user clicks on {string} category in mews page horizontal menu")
    public void clickOnCoronaVitusCategory(String category) {
        getNewsHorizontalMenu().getMenuCategoryInNewsPageMenu(category).click();
    }

    @When("user clicks on Your coronavirus Stories link")
    public void clicksOnYourCoronavirusStoriesLink() {
        getCoronaVirusPage().clickOnLinkYourCoronavirusStories();
    }

    @When("user clicks on How to share with BBC link")
    public void clicksOnHowToShareWithBBCLink() {
        getCoronaVirusPage().clickOnLinkShareCoronavirusStory();
    }

    @When("clicks on news headline article category link")
    public void clickOnNewsHeadlineArticleCategoryLink() {
        newsHeadLineArticleCategory = getNewsPage().getTextNewsHeadLineArticleCategory();
        getNewsPage().clickOnLinkNewsHeadLineCategory();
    }

    @Then("headline article category on category page equal to headline article category on news page")
    public void checkHeadlineArticleCategoryOnCategoryPageEqualToHeadlineArticleCategoryOnNewsPage() {
        assertThat(getNewsPage().getTextCategoryHeadLineArticleCategory())
                .as("Text of headline article category on category page is NOT equal to text headline article category on news page")
                .isEqualTo(newsHeadLineArticleCategory);
        newsHeadLineArticleCategory = null;
    }
}
