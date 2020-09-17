package com.bbc.ta.tests;

import com.bbc.ta.pages.news_page.CoronavirusStorySubmissionForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class CoronavirusStorySubmissionTest extends BaseTest {

    private static final String CORONA_SHARE_STORY_VALID_NAME = "Oleksii";
    private static final String CORONA_SHARE_STORY_VALID_STORY = "I have some coronavirus story to tell";
    private static final String CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT = "must be accepted";

    private final HashMap<CoronavirusStorySubmissionForm.Field, String> fieldsSubmissionFormValues = new HashMap<>();
    private final HashMap<CoronavirusStorySubmissionForm.Checkbox, Boolean> checkboxesSubmissionFormValues = new HashMap<>();

    @BeforeMethod
    private void navigateToSubmissionForm() {
        getCoronavirusStorySubmissionForm()
                .navigateToSubmissionForm();
    }

    @AfterMethod
    private void cleanSubmissionFormValues() {
        fieldsSubmissionFormValues.clear();
        checkboxesSubmissionFormValues.clear();
    }

    @Test
    public void checkCoronaVirusStorySubmissionFormResponseOnEmptyStoryTextArea() {

        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.NAME, CORONA_SHARE_STORY_VALID_NAME);

        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_AM_OVER_SIXTEEN, true);
        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_ACCEPT, true);

        getCoronavirusStorySubmissionForm()
                .submitCoronaStorySubmissionForm(
                        fieldsSubmissionFormValues,
                        checkboxesSubmissionFormValues);

        assertEquals(
                getCoronavirusStorySubmissionForm().getTextErrorCoronaStorySubmissionFrom(),
                "can't be blank",
                "Text of my coronavirus story form textarea error message is NOT equal to expected");
    }

    @Test
    public void checkCoronaVirusStorySubmissionFormResponseOnEmptyNameInput() {

        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.STORY, CORONA_SHARE_STORY_VALID_STORY);

        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_AM_OVER_SIXTEEN, true);
        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_ACCEPT, true);

        getCoronavirusStorySubmissionForm()
                .submitCoronaStorySubmissionForm(
                        fieldsSubmissionFormValues,
                        checkboxesSubmissionFormValues);

        assertEquals(
                getCoronavirusStorySubmissionForm().getTextErrorCoronaStorySubmissionFrom(),
                "Name can't be blank",
                "Text of my coronavirus story form name input error message is NOT equal to expected");
    }

    @Test
    public void checkCoronaVirusStorySubmissionFormResponseOnUncheckedIAmOverSixteenCheckbox() {
        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.STORY, CORONA_SHARE_STORY_VALID_STORY);
        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.NAME, CORONA_SHARE_STORY_VALID_NAME);

        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_ACCEPT, true);

        getCoronavirusStorySubmissionForm()
                .submitCoronaStorySubmissionForm(
                        fieldsSubmissionFormValues,
                        checkboxesSubmissionFormValues);

        assertEquals(
                getCoronavirusStorySubmissionForm().getTextErrorCoronaStorySubmissionFrom(),
                CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT,
                "Text of my coronavirus story form required checkboxes error message is NOT equal to expected");

    }

    @Test
    public void checkCoronaVirusStorySubmissionFormResponseOnUncheckedIAcceptTermsCheckbox() {
        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.STORY, CORONA_SHARE_STORY_VALID_STORY);
        fieldsSubmissionFormValues.put(CoronavirusStorySubmissionForm.Field.NAME, CORONA_SHARE_STORY_VALID_NAME);

        checkboxesSubmissionFormValues.put(CoronavirusStorySubmissionForm.Checkbox.I_AM_OVER_SIXTEEN, true);

        getCoronavirusStorySubmissionForm()
                .submitCoronaStorySubmissionForm(
                        fieldsSubmissionFormValues,
                        checkboxesSubmissionFormValues);

        assertEquals(
                getCoronavirusStorySubmissionForm().getTextErrorCoronaStorySubmissionFrom(),
                CORONA_SHARE_STORY_FORM_CHECKBOX_ERROR_TEXT,
                "Text of my coronavirus story form required checkboxes error message is NOT equal to expected");
    }

}
