

Feature: Verify Account Information
  Verify Account Informatiom is correct for different types od Accounts

  @account
  Scenario: Verify Account Details
    Given user is on the Home Page
    And user clicks on Login button
    And user verify Login page URL
    And user verify Login Page logo
    And user login with valid credentials
    When user dashboard is displayed
    Then user verify email
    And user verify Account type
    And user verify First Name
    And user Verify Last Name
    When user clicks Logout button 
    Then user verify Login page URL
    And user verify Login Page logo
    Then user closes the browser
    


