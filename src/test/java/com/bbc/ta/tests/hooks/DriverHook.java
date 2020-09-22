package com.bbc.ta.tests.hooks;

import com.bbc.ta.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHook {

    @Before
    public void setupDriver() {
        DriverManager.getDriver("chrome");
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
