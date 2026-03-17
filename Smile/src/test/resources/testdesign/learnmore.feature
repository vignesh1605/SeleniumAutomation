Feature: Learnmore

  @learnmore  @abc
    Scenario: error message validation
    Given user navigates to learnmore page
    When user enters the user name "LearnMore" and password "123"
    And user clicks the login button
    Then validate the error message
