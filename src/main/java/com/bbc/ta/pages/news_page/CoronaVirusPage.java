package com.bbc.ta.pages.news_page;

import com.bbc.ta.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronaVirusPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Your Coronavirus Stories']/ancestor::a")
    private WebElement linkYourCoronavirusStories;

    @FindBy(xpath = "//h3[contains(text(),'How to share')]//ancestor::a")
    private WebElement linkShareCoronavirusStory;

    public CoronaVirusPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLinkYourCoronavirusStories() {
        waitForElementVisibility(linkYourCoronavirusStories);
        linkYourCoronavirusStories.click();
    }

    public void clickOnLinkShareCoronavirusStory() {
        waitForElementVisibility(linkShareCoronavirusStory);
        linkShareCoronavirusStory.click();
    }
}
