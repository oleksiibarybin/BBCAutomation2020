package com.bbc.ta.tests.hooks;

import com.bbc.ta.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class DriverHook {

    private static WebDriver driver;

    @Before
    public void setupDriver() {
        driver = DriverManager.getDriver("chrome");
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
