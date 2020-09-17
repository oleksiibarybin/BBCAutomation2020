package com.bbc.ta.pages;

import com.bbc.ta.pages.common.MainHorizontalMenu;
import com.bbc.ta.pages.news_page.NewsHorizontalMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setCheckboxChecked(WebElement element) {
        if (!element.isSelected())
            element.click();
    }

    public NewsHorizontalMenu getNewsHorizontalMenu() {
        return new NewsHorizontalMenu(driver);
    }

    public MainHorizontalMenu getMainHorizontalMenu() {
        return new MainHorizontalMenu(driver);
    }
}
