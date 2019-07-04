@ValidateEmail
Feature: Validate User Email address for creating an account
  Background: User is on automation practice website and navigates to Create an account page by clicking 'Sign In' link
  Scenario: 1. Verify that user is successfully navigated to 'Create An Account' form when a valid email is provided
    Given User is on "CREATE AN ACCOUNT" form with valid email address
    When User enters a valid email address in the email field
    And Clicks on "Create An Account" button for registration with valid email address
    Then User is navigated to the "Create an account" form with title "Login - My Store"

  Scenario: 2. Verify that the user gets an error message if the email provided is not valid.
    Given User is on "CREATE AN ACCOUNT" form with invalid email address
    When User enters an invalid email address in the email field
    And Clicks on "Create An Account" button for registration with invalid email address
    Then User is displayed with an error message as "Invalid email address."

  Scenario: 3. Verify that the user gets an error message if the email provided is already registered.
    Given User is on "CREATE AN ACCOUNT" form with already registered email address
    When User enters an already registered email address in the email field
    And Clicks on "Create An Account" button for registration with already registered email address
    Then User is displayed with an error message as "An account using this email address has already been registered. Please enter a valid password or request a new one."