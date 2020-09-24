package com.bbc.ta.pages.news_page;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsHorizontalMenu extends NewsPage {

    @FindBy(xpath = "//span[text()='Coronavirus']/ancestor::a")
    private WebElement coronavirusCategory;

    public NewsHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuCategoryInNewsPageMenu(String category) {
        switch (category) {
            case "coronavirus": {
                coronavirusCategory.click();
                break;
            }
            default:
                throw new NotImplementedException(String.format("Category %s is not implemented", category));
        }
    }

}
