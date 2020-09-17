package com.bbc.ta.tests;

import com.bbc.ta.driver.DriverManager;
import com.bbc.ta.pages.common.MainHorizontalMenu;
import com.bbc.ta.pages.common.SignInPopUp;
import com.bbc.ta.pages.news_page.CoronavirusStorySubmissionForm;
import com.bbc.ta.pages.news_page.NewsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void testSetUp() {
        driver = DriverManager.getDriver("chrome");
        getSignInPopUp().registrationPopUpHandler();
    }

    @AfterClass
    public void testTearDown() {
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SignInPopUp getSignInPopUp() {
        return new SignInPopUp(getDriver());
    }

    public MainHorizontalMenu getMainHorizontalMenu() {
        return new MainHorizontalMenu(getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(getDriver());
    }

    public CoronavirusStorySubmissionForm getCoronavirusStorySubmissionForm() {
        return new CoronavirusStorySubmissionForm(getDriver());
    }

}
