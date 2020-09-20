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

    public WebElement getMenuCategoryInNewsPageMenu(String category) {
        switch (category) {
            case "coronavirus": {
                return coronavirusCategory;
            }
        }
        return null;
    }

}
