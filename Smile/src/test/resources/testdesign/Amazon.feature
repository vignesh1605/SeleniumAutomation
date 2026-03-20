Feature: To validate the Amazon Functionality


  @SearchAction @SC01 @regressiontest
  Scenario: Search Functionality
#    Given user navigates to Amazon Homepage
    When user enters the product name "iphone" in search box
    And user clicks the search icon
    Then user Validates the title of search result page

  @BabyWishlist @smoketest
    Scenario: click the baby wishlist
#    Given user navigates to Amazon Homepage
    When user click the baby wishlist

    #before
  @DragAndDrop
  Scenario: drag and drop validation
    #Given user navigates to drag and drop page
    When user drag and drop the element
    #after

  @StaticDropdown @smoketest
  Scenario: static dropdown functionality
#    Given user navigates to Amazon Homepage
    When user select the dropdown value
    And user read the selective option dropdown

  @TableHandling
  Scenario: table handling functionality
    When user selecting the table
    And user extracting the table data

  @salesforeceLogin
  Scenario: validating the Login page
#    Given user navigates to salesforce loginpage
    When user enters the username "iphone" and password "123"
    And user click the login button
    Then user validating the error message

