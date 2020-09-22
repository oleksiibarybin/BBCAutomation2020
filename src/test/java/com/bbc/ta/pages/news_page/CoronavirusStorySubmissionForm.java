package com.bbc.ta.pages.news_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoronavirusStorySubmissionForm extends CoronaVirusPage {

    @FindBy(xpath = "//div[@class='embed-content-container']")
    private WebElement blockStorySubmissionForm;

    @FindBy(xpath = "//textarea[@aria-label='Tell us your story. ']")
    private WebElement inputTextareaStoryCoronaStorySubmissionForm;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement inputNameCoronaStorySubmissionForm;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBoxesCoronaStorySubmissionForm;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement buttonSubmitCoronaStorySubmissionForm;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement textErrorCoronaStorySubmissionFrom;

    public CoronavirusStorySubmissionForm(WebDriver driver) {
        super(driver);
    }

    public void navigateToSubmissionForm() {
        getMainHorizontalMenu()
                .clickOnNewsPageLink()
                .getNewsHorizontalMenu()
                .clickOnCoronavirusPageLink()
                .clickOnLinkCoronavirusStory()
                .clickOnLinkShareCoronavirusStory();
    }

    public void submitCoronaStorySubmissionForm(Map<Field, String> fields, List<Checkbox> checkboxes) {
        waitForElementVisibility(blockStorySubmissionForm);
        setFieldsCoronaVirusSubmissionForm(fields, checkboxes);
        clickOnButtonSubmitCoronaStorySubmissionForm();
    }

    public String getTextErrorCoronaStorySubmissionFrom() {
        waitForElementVisibility(textErrorCoronaStorySubmissionFrom);
        return textErrorCoronaStorySubmissionFrom.getText();
    }

    private void setFieldsCoronaVirusSubmissionForm(Map<Field, String> fields, List<Checkbox> checkboxes) {
        for (Field key : fields.keySet()) {
            switch (key) {
                case STORY:
                    inputTextareaStoryCoronaStorySubmissionForm.sendKeys(fields.get(key));
                    break;
                case NAME:
                    inputNameCoronaStorySubmissionForm.sendKeys(fields.get(key));
                    break;
                default: throw new EnumConstantNotPresentException(Field.class, key.name());
            }
        }
        for (Checkbox key : checkboxes) {
            switch (key) {
                case I_AM_OVER_SIXTEEN:
                    setCheckboxChecked(checkBoxesCoronaStorySubmissionForm.get(1));
                    break;
                case I_ACCEPT:
                    setCheckboxChecked(checkBoxesCoronaStorySubmissionForm.get(2));
                    break;
                default: throw new EnumConstantNotPresentException(Checkbox.class, key.name());
            }
        }
    }

    private void clickOnButtonSubmitCoronaStorySubmissionForm() {
        buttonSubmitCoronaStorySubmissionForm.click();
    }

    public enum Field {
        STORY,
        NAME,
        EMAIL
    }

    public enum Checkbox {
        I_AM_OVER_SIXTEEN,
        I_ACCEPT
    }

}
