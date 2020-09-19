package com.bbc.ta.pages.common;

import com.bbc.ta.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPopUp extends HomePage {

    @FindBy(xpath = "//button[@data-bbc-title]")
    private WebElement buttonSignInLater;

    public SignInPopUp(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInLaterButton() {
        waitForPopUpLoad(driver);
        buttonSignInLater.click();
    }

    public void registrationPopUpHandler() {
        driver.get(BASE_URL);
        new MainHorizontalMenu(driver).clickOnNewsPageLink();
        waitForPopUpLoad(driver);
        new SignInPopUp(driver).clickOnSignInLaterButton();
    }

}
