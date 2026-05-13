Feature: Login

  Scenario: Login with valid credentials
    Given Bob is a registered user
    When Bob logs in with valid credentials
    Then Bob sees the success message "Welcome back, Bob"

  Scenario: Login with invalid credentials
    Given Bob is a registered user but
    When Bob logs in with invalid credentials
    Then Bob sees the failure message "Login failed"

  #Scenario Outline: Log in with valid or missing or invalid credentials
    #Given Bob is a registered user with "<reg_email>" and "<reg_password>"
    #When Bob logs in with "<log_email>" and "<log_password>"
    #Then Bob sees the following "<message>"

    #Examples:
      #| reg_email    | reg_password | log_email    | log_password | message            |
      #| bob@test.com | TestBob123   | bob@test.com | TestBob123   | Welcome back, Bob  |
      #| bob@test.com | TestBob123   | "" | TestBob123   | Login failed  |
      #| bob@test.com | TestBob123   | bob@test.com | ""   | Login failed   |
      #| bob@test.com | TestBob123   | bob@test.com | TestBob1234   | Login failed  |
      #| bob@test.com | TestBob123   | bobi@test.com | TestBob123   | Login failed  |