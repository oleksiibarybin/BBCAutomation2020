package com.bbc.ta.tests.steps.common;

import com.bbc.ta.tests.utils.PageFactory;
import io.cucumber.java.en.When;

public class SignInPopUpSteps {

    @When("declines sign in proposition on pop up window")
    public void declineSignInPropositionOnPopUpWindow() {
        PageFactory.getSignInPopUp().clickOnSignInLaterButton();
    }
}
