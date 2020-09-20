Feature: As an unregistered user I want to publish my coronavirus story so that I can share this story with others

  Background: Navigation to coronavirus story submission form
    Given the unregistered user opens BBC website
    When user clicks on "news" category in main horizontal menu
    And declines sign in proposition on pop up window
    And user clicks on "coronavirus" category in mews page horizontal menu
    And user clicks on Your coronavirus Stories link
    And user clicks on How to share with BBC link

  Scenario Outline: Error message should be shown in case empty required story submission form element
    And user enters "<story>" to "story" field
    And user enters "<name>" to "name" field
    And user checks in "<i_am_over_sixteen>" checkbox
    And user checks in "<i_accept>" checkbox
    And user clicks on submit button
    Then below form element error message "<message>" is shown

    Examples:
      | story      | name    | i_am_over_sixteen | i_accept | message             |
      |            | Oleksii | i_am_over_sixteen | i_accept | can't be blank      |
      | Real story |         | i_am_over_sixteen | i_accept | Name can't be blank |
      | Real story | Oleksii |                   | i_accept | must be accepted    |
      | Real story | Oleksii | i_am_over_sixteen |          | must be accepted    |
