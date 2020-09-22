package com.bbc.ta.tests.steps.common;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class NewsPageSteps {

    @When("user clicks on {string} category in mews page horizontal menu")
    public void clickOnCoronaVitusCategory(String category) {
        PageFactory
                .getNewsHorizontalMenu()
                .clickOnMenuCategoryInNewsPageMenu(category);
    }

    @When("user clicks on Your coronavirus Stories link")
    public void clicksOnYourCoronavirusStoriesLink() {
        PageFactory
                .getCoronaVirusPage()
                .clickOnLinkYourCoronavirusStories();
    }

    @When("user clicks on How to share with BBC link")
    public void clicksOnHowToShareWithBBCLink() {
        PageFactory
                .getCoronaVirusPage()
                .clickOnLinkShareCoronavirusStory();
    }

    @When("clicks on news headline article category link")
    public void clickOnNewsHeadlineArticleCategoryLink() {
        PageFactory
                .getNewsPage()
                .clickOnLinkNewsHeadLineCategory();
    }

    @Then("headline article category on category page equal to headline article category on news page")
    public void checkHeadlineArticleCategoryOnCategoryPageEqualToHeadlineArticleCategoryOnNewsPage() {
        String newsHeadLineArticleCategory = PageFactory.getNewsPage().getTextNewsHeadLineArticleCategory();
        assertThat(PageFactory.getNewsPage().getTextCategoryHeadLineArticleCategory())
                .as("Text of headline article category on category page is NOT equal to text headline article category on news page")
                .isEqualTo(newsHeadLineArticleCategory);
    }
}
