package com.bbc.ta.tests.steps;

import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsTitlesSteps extends BaseSteps {

    @Then("headline article {string} contains latest news title")
    public void checkNewsHeadlineArticleTitle(String headlineArticleTitle) {
        assertThat(getNewsPage().getTextNewsHeadLineTitle())
                .isEqualTo(headlineArticleTitle);
    }
}
