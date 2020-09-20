package com.bbc.ta.tests.steps;

import com.bbc.ta.tests.steps.common.BaseSteps;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsTitlesSteps extends BaseSteps {

    @Then("headline article contains latest news title")
    public void checkNewsHeadlineArticleTitle(String headlineArticleTitle) {
        assertThat(getNewsPage().getTextNewsHeadLineTitle())
                .as("Text of news category headline title is NOT equal to expected")
                .isEqualTo(headlineArticleTitle);
    }

    @Then("secondary articles titles contain latest news titles")
    public void checkNewsSecondaryTitles(List<String> expectedTitles) {
        assertThat(getNewsPage().getTextForFirstSixSecondaryTitles())
                .as("Text of news category one of secondary titles is NOT equal to expected")
                .containsAll(expectedTitles);
    }
}
