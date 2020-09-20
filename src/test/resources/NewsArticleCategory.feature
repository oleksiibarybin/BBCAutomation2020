Feature: As a user I want to open all news related to article category so that I can find all related to category news

  Background: Navigation to news page
    Given the unregistered user opens BBC website
    When user clicks on "news" category in main horizontal menu
    And declines sign in proposition on pop up window

  Scenario: News headline article category on category page should be equal to news headline article category on news page
    And clicks on news headline article category link
    Then headline article category on category page equal to headline article category on news page