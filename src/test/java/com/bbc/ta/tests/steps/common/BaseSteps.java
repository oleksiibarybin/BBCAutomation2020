package com.bbc.ta.tests.steps.common;

import com.bbc.ta.pages.HomePage;
import com.bbc.ta.pages.common.MainHorizontalMenu;
import com.bbc.ta.pages.common.SignInPopUp;
import com.bbc.ta.pages.news_page.CoronaVirusPage;
import com.bbc.ta.pages.news_page.CoronavirusStorySubmissionForm;
import com.bbc.ta.pages.news_page.NewsHorizontalMenu;
import com.bbc.ta.pages.news_page.NewsPage;
import com.bbc.ta.tests.hooks.DriverHook;

public class BaseSteps {

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

    public NewsHorizontalMenu getNewsHorizontalMenu() {
        return new NewsHorizontalMenu(DriverHook.getDriver());
    }

    public CoronaVirusPage getCoronaVirusPage() {
        return new CoronaVirusPage(DriverHook.getDriver());
    }

    public CoronavirusStorySubmissionForm getCoronavirusStorySubmissionForm() {
        return new CoronavirusStorySubmissionForm(DriverHook.getDriver());
    }
}
