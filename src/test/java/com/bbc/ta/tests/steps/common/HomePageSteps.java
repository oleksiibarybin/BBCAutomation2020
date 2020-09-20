package com.bbc.ta.tests.steps.common;

import io.cucumber.java.en.Given;

public class HomePageSteps extends BaseSteps{

    @Given("the unregistered user opens BBC website")
    public void openBbcWebsite(){
        getHomePage().openBbcWebSite();
    }
}
