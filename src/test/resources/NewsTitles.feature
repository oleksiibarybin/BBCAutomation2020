Feature: As an unregistered user I want to get up-to-date news so that I will be aware of the latest events

  Scenario: News headline article title should correspond up-to-date latest news title
    Given the unregistered user opens BBC website
    When user clicks on "news" category in main horizontal menu
    And declines sign in proposition on pop up window
    Then headline article "Madrid virus lockdowns to hit over 850,000 people" contains latest news title