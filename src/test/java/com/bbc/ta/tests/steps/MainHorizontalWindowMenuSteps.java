package com.bbc.ta.tests.steps;

import io.cucumber.java.en.When;

public class MainHorizontalWindowMenuSteps extends BaseSteps {

    @When("user clicks on {string} category in main horizontal menu")
    public void clickOnMainHorizontalMenuCategory(String category) {
        getMainHorizontalMenu().menuCategory(category).click();
    }
}
