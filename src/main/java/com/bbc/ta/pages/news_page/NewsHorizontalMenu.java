package com.bbc.ta.pages.news_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsHorizontalMenu extends NewsPage {

    @FindBy(xpath = "//span[text()='Coronavirus']/ancestor::a")
    private WebElement coronavirusCategory;

    public NewsHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public CoronaVirusPage clickOnCoronavirusPageLink() {
        waitForElementVisibility(coronavirusCategory);
        coronavirusCategory.click();
        return new CoronaVirusPage(driver);
    }
}
