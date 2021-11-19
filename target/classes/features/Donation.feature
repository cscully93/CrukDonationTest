@donation
Feature: Test the Donation Functionality on CRUK

  @positive
  Scenario: Make donation on CRUK
    Given the user is on the home page
    When the user enters other amount of 25
    And the user selects the own money radio button
    And the user selects motivation of In memory of someone
    And the user selects the greatest need radio button
    And the user clicks on Continue button
    And the user selects title as Mr
    And the user enters first name as Joe
    And the user enters surname as Bloggs
    And the user enters email address as joe@bloggs.com
    And the user enters phone number as 0861234567
    And the user enters post code as JB16 3GS
    And the user clicks on Continue button on second page
    And the user selects the PayPal option
    Then verify the user is on the payments page

  @negative
  Scenario: Empty values on Donation Amount page
    Given the user is on the home page
    When the user clicks on Continue button
    Then verify correct empty error messages are displayed on donation page

  @negative
  Scenario Outline: Invalid values on Donation Amount page
    Given the user is on the home page
    When the user enters other amount of <invalidAmount>
    And the user clicks on Continue button
    Then verify correct invalid error messages are displayed on donation page
    Examples:
      | invalidAmount |
      | abc           |
      | @.@           |
      | €&#           |

  @negative
  Scenario: Empty values on Contact Details page
    Given the user is on the home page
    And the user completes the donation page
    When the user clicks on Continue button on second page
    Then verify correct empty error messages are displayed on contact details page

  @negative
  Scenario Outline: Invalid values on Contact Details page
    Given the user is on the home page
    When the user completes the donation page
    And the user selects title as Mr
    And the user enters first name as <firstName>
    And the user enters surname as <surname>
    And the user enters email address as <emailAddress>
    And the user enters phone number as <phoneNumber>
    And the user enters invalid post code as <postCode>
    And the user clicks on Continue button on second page
    Then verify correct invalid error messages are displayed on contact details page
    Examples:
      | firstName | surname | emailAddress | phoneNumber | postCode |
      | 90        | @;s     | joebloggs    | phone       | 321      |
      | @.@       | 123     | ';'          | 4321        | lk       |

  @negative
  Scenario: Surname field short on Contact Details page
    Given the user is on the home page
    When the user completes the donation page
    And the user selects title as Mr
    And the user enters surname as d
    And the user clicks on Continue button on second page
    Then verify correct surname too short error message is displayed on contact details page