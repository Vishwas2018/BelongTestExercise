@Registration
Feature: User should be able to register using a valid email address
  Scenario: Verify that user is able to navigate to 'Authentication' Page
    Given User is on the automation practice website home page with title "My Store"
    When User clicks on "Sign In" link
    Then User is the navigated to the authentication page with title "Login - My Store"

  Scenario: Verify that user is able to navigate to 'Create An Account' Page
    Given User is on the authentication Page with title "Login - My Store"
    When User enters a valid email address in the email address field
    And Clicks on "CreateAnAccount" button
    Then User is navigated to the "CREATE AN ACCOUNT" Form

  Scenario: Verify that the user is able to register successfully
    Given User is on "CREATE AN ACCOUNT" Form with title "Login - My Store"
    When User fills up the form with all details
    And Clicks on "Register" button on create an account form page
    Then The registration is successful and user is able to see my account page with title "My account - My Store" Page.