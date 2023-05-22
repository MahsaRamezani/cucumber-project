Feature: Baam Login with multiple data
  @datadriven
  Scenario Outline: Attempt Login with specific credentials
    Given the user is on the login page
    When the user enters user id as "<user>"
    And enters password as "<password>"
    And hits submit
    Then the user should be logged in successfully

    Examples:
    | user      | password |
    | BaamUser1 | abc123   |
    | BaamUser2 | zxy123   |
    | BaamUser3 | abc123   |
    | BaamUser4 | zxy123   |