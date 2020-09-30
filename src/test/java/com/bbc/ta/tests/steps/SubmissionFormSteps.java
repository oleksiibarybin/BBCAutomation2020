package com.bbc.ta.tests.steps;

import com.bbc.ta.tests.utils.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SubmissionFormSteps {

    @When("user enters {string} to {string} field")
    public void setValueToSubmissionFormField(String value, String fieldName) {
        PageFactory
                .getCoronavirusStorySubmissionForm()
                .setValueToFieldInCoronaStorySubmissionForm(value, fieldName);
    }

    @When("user checks in {string} checkbox")
    public void setCheckboxChecked(String checkbox) {
        PageFactory
                .getCoronavirusStorySubmissionForm()
                .checkCheckboxInCoronaStorySubmissionForm(checkbox);
    }

    @When("user clicks on submit button")
    public void clicksOnSubmitButton() {
        PageFactory
                .getCoronavirusStorySubmissionForm()
                .clickOnButtonSubmitCoronaStorySubmissionForm();
    }

    @Then("below form element error message {string} is shown")
    public void checkErrorMessageText(String message) {
        assertThat(
                PageFactory
                        .getCoronavirusStorySubmissionForm()
                        .getTextErrorCoronaStorySubmissionFrom())
                .as("Text of my coronavirus error message is NOT equal to expected")
                .isEqualTo(message);
    }
}
