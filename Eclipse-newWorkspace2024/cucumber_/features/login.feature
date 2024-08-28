Feature: User Login

  Scenario: Successful user login
    Given user is on nveen automation labs page
    When user enters the valid credentials "momtomylittleman@gmail.com" and "1234"
    And the user clicks on the login button
    Then user should be redirected to the account page
    And user should see a welcome message
