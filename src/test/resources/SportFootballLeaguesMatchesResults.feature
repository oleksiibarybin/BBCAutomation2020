Feature: As an unregistered user I want to see football leagues matches results so that I can be aware of league progress

  Background: Navigation to coronavirus story submission form
    Given the unregistered user opens BBC website
    When user clicks on "sport" category in main horizontal menu
    And declines sign in proposition on pop up window
    And user clicks on "football" category in sport page horizontal menu
    And user clicks on "scores-fixtures" category in sport page football horizontal menu


  Scenario Outline: Error message should be shown in case empty required story submission form element
    And user enters "<championship>" to search field
    And user select first result below search field
    And user select first month results in league current season
    Then user see in "last_month_match" that "<first_command_ame>" and "<second_command_name>" match result is "<firs_command_score>" - "<second_command_score>"
    And user clicks on link to last match results details
    Then user see in "event_header" that "<first_command_ame>" and "<second_command_name>" match result is "<firs_command_score>" - "<second_command_score>"

    Examples:
      | championship          | first_command_ame | second_command_name | firs_command_score | second_command_score |
      | Champions League      | Club Bruges       | Galatasaray         | 0                  | 0                    |
      | Scottish Championship | Arbroath          | Ayr United          | 0                  | 3                    |

