package com.bbc.ta.tests.steps;

import com.bbc.ta.pages.HomePage;
import com.bbc.ta.pages.common.MainHorizontalMenu;
import com.bbc.ta.pages.common.SignInPopUp;
import com.bbc.ta.pages.news_page.CoronavirusStorySubmissionForm;
import com.bbc.ta.pages.news_page.NewsPage;
import com.bbc.ta.tests.hooks.DriverHook;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    private WebDriver driver;

    /*public WebDriver getDriver() {
        return driver;
    }*/

    public HomePage getHomePage() {
        return new HomePage(DriverHook.getDriver());
    }

    public SignInPopUp getSignInPopUp() {
        return new SignInPopUp(DriverHook.getDriver());
    }

    public MainHorizontalMenu getMainHorizontalMenu() {
        return new MainHorizontalMenu(DriverHook.getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(DriverHook.getDriver());
    }

    public CoronavirusStorySubmissionForm getCoronavirusStorySubmissionForm() {
        return new CoronavirusStorySubmissionForm(DriverHook.getDriver());
    }


}
