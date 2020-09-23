package com.bbc.ta.tests.steps.common;

import com.bbc.ta.driver.DriverManager;
import com.bbc.ta.pages.HomePage;
import com.bbc.ta.pages.common.MainHorizontalMenu;
import com.bbc.ta.pages.common.SignInPopUp;
import com.bbc.ta.pages.news_page.CoronaVirusPage;
import com.bbc.ta.pages.news_page.CoronavirusStorySubmissionForm;
import com.bbc.ta.pages.news_page.NewsHorizontalMenu;
import com.bbc.ta.pages.news_page.NewsPage;
import com.bbc.ta.pages.sport_page.FootballHorizontalMenu;
import com.bbc.ta.pages.sport_page.FootballPage;
import com.bbc.ta.pages.sport_page.SportHorizontalMenu;

public class PageFactory {

    public static HomePage getHomePage() {
        return new HomePage(DriverManager.getDriver());
    }

    public static SignInPopUp getSignInPopUp() {
        return new SignInPopUp(DriverManager.getDriver());
    }

    public static MainHorizontalMenu getMainHorizontalMenu() {
        return new MainHorizontalMenu(DriverManager.getDriver());
    }

    public static NewsPage getNewsPage() {
        return new NewsPage(DriverManager.getDriver());
    }

    public static NewsHorizontalMenu getNewsHorizontalMenu() {
        return new NewsHorizontalMenu(DriverManager.getDriver());
    }

    public static SportHorizontalMenu getSportHorizontalMenu() {
        return new SportHorizontalMenu(DriverManager.getDriver());
    }

    public static FootballPage getFootballPage() {
        return new FootballPage(DriverManager.getDriver());
    }

    public static FootballHorizontalMenu getFootballHorizontalMenu() {
        return new FootballHorizontalMenu(DriverManager.getDriver());
    }

    public static CoronaVirusPage getCoronaVirusPage() {
        return new CoronaVirusPage(DriverManager.getDriver());
    }

    public static CoronavirusStorySubmissionForm getCoronavirusStorySubmissionForm() {
        return new CoronavirusStorySubmissionForm(DriverManager.getDriver());
    }
}
