package com.bbc.ta.tests.steps;

import com.bbc.ta.pages.common.SignInPopUp;
import io.cucumber.java.en.When;

public class SignInPopUpSteps extends BaseSteps {

    //private final SignInPopUp signInPopUp = new SignInPopUp();

    @When("declines sign in proposition on pop up window")
    public void declineSignInPropositionOnPopUpWindow() {
        getSignInPopUp().clickOnSignInLaterButton();
    }


}
