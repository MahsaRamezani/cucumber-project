@critical
Feature: Baam Login

  @authenticate @functional
  Scenario: User should be able to login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged in successfully

  @regression @functional @block
  Scenario: Attempt Login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    And hits submit
    Then an invalid credentials error message should be displayed to the user
    And login should be unsuccessful

  @ui
  Scenario: Check for Baam logo on login form
    Given the user is on the login page
    Then the Baam Logo should be present in the login form

  @forgotFlow
  Scenario: Initiate Forgot password flow
    Given the user is on the login page
    When the user clicks on Forgot Username
    Then the user should be navigated to the first page of forgot username flow