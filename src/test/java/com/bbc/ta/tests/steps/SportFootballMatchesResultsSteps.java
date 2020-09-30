package com.bbc.ta.tests.steps;

import com.bbc.ta.tests.utils.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SportFootballMatchesResultsSteps {

    @Then("user see in {string} that {string} and {string} match result is {string} - {string}")
    public void checkLastMatchResults(String page,
                                      String expectedFirstCommandName,
                                      String expectedSecondCommandName,
                                      String expectedFirstCommandScore,
                                      String expectedSecondCommandScore) {

        List<String> expectedMatchResults = new ArrayList<>();
        List<String> itemsMatchResults = new ArrayList<>();

        itemsMatchResults.add("First Command Name");
        itemsMatchResults.add("Second Command Name");
        itemsMatchResults.add("First Command Score");
        itemsMatchResults.add("Second Command Score");

        expectedMatchResults.add(expectedFirstCommandName);
        expectedMatchResults.add(expectedSecondCommandName);
        expectedMatchResults.add(expectedFirstCommandScore);
        expectedMatchResults.add(expectedSecondCommandScore);

        List<String> actualMatchResults = PageFactory
                                                .getFootballPage()
                                                .getMatchResults(page);

        assertThat(actualMatchResults)
                .as("\nFor items %s \nvalues %s \nis NOT equal to expected \n%s",
                        itemsMatchResults, expectedMatchResults, actualMatchResults)
                .isEqualTo(expectedMatchResults);
    }

    @When("user clicks on link to last match results details")
    public void clickOnLinkToLastMatchResultsDetails() {
        PageFactory
                .getFootballPage()
                .clickOnLinkLastMatchResultsDetails();
    }
}
