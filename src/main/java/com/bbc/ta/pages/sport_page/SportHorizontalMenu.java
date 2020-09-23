package com.bbc.ta.pages.sport_page;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportHorizontalMenu extends SportPage{

    @FindBy(xpath = "//div[@role='menubar']//a[@data-stat-link='/sport/football']")
    private WebElement footballCategory;

    public SportHorizontalMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuCategoryInSportPageMenu(String category) {
        switch (category) {
            case "football": {
                footballCategory.click();
                break;
            }
            default: throw new NotImplementedException(String.format("Category %s is not implemented", category));
        }
    }
}
