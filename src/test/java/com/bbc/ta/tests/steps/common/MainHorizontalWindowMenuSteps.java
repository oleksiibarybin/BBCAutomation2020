package com.bbc.ta.tests.steps.common;

import io.cucumber.java.en.When;

public class MainHorizontalWindowMenuSteps{

    @When("user clicks on {string} category in main horizontal menu")
    public void clickOnMainHorizontalMenuCategory(String category) {
        PageFactory.getMainHorizontalMenu().clickOnMainMenuCategory(category);
    }

}
