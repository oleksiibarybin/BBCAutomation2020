package com.bbc.ta.pages.news_page;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public void setValueToFieldInCoronaStorySubmissionForm(String value, String fieldName) {
        waitForElementVisibility(blockStorySubmissionForm);
        switch (fieldName) {
            case "story":
                inputTextareaStoryCoronaStorySubmissionForm.sendKeys(value);
                break;
            case "name":
                inputNameCoronaStorySubmissionForm.sendKeys(value);
                break;
            default:
                throw new NotImplementedException(String.format("Field %s is not implemented", fieldName));
        }
    }

    public void checkCheckboxInCoronaStorySubmissionForm(String checkbox) {
        switch (checkbox) {
            case "i_am_over_sixteen":
                setCheckboxChecked(checkBoxesCoronaStorySubmissionForm.get(1));
                break;
            case "i_accept":
                setCheckboxChecked(checkBoxesCoronaStorySubmissionForm.get(2));
                break;
            case "is_not_checked":
                break;
            default:
                throw new NotImplementedException(String.format("Checkbox %s is not implemented", checkbox));
        }
    }

    public void clickOnButtonSubmitCoronaStorySubmissionForm() {
        buttonSubmitCoronaStorySubmissionForm.click();
    }

    public String getTextErrorCoronaStorySubmissionFrom() {
        waitForElementVisibility(textErrorCoronaStorySubmissionFrom);
        return textErrorCoronaStorySubmissionFrom.getText();
    }
}
