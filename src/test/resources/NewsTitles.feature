Feature: As an unregistered user I want to get up-to-date news so that I will be aware of the latest events

  Background: Navigation to news page
    Given the unregistered user opens BBC website
    When user clicks on "news" category in main horizontal menu
    And declines sign in proposition on pop up window

  Scenario: News headline article title should correspond up-to-date latest news title
    Then headline article contains latest news title
      |US Supreme Court Judge Ruth Bader Ginsburg dies|


  Scenario: News secondary articles title should correspond up-to-date latest news title
    Then secondary articles titles contain latest news titles
      |Thais gather for mass anti-government rally|
      |US reinforcements sent to Syria after Russia clashes|
      |Johnson considers new measures as UK cases surge            |
      |Madrid virus lockdowns to hit over 850,000 people|
      |Animals 'dying of hunger and thirst' in Pantanal fires|
      |Two shot dead and 14 hurt in Rochester, New York   |

