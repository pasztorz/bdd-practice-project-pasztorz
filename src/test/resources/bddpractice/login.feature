Feature: Login
  Registered Users can log in with valid credentials
  Registered Users cannot log in with missing or invalid credentials
  Registered Users cannot log in without entering credentials
  Unregistered Users cannot log in but get "Unregistered user" failure notice

  Scenario Outline: Log in with valid or missing or invalid credentials
    Given Bob is a registered user
    When Bob logs in with "<login_email>" and "<login_password>"
    Then Bob sees the following "<message>"

    Examples:
      | login_email   | login_password | message           |
      | bob@test.com  | TestBob123     | Welcome back, Bob |
      |               |                | Login failed      |
      |               | TestBob123     | Login failed      |
      | bob@test.com  |                | Login failed      |
      | bob@test.com  | TestBob1234    | Login failed      |
      | bobi@test.com | TestBob123     | Login failed      |

  Scenario: Login with not registered user
    Given Rob is an unregistered user
    When Rob logs in with new credentials
    Then Rob sees the following message "Unregistered user"
