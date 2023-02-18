Feature: Login Functionality test

  @validLogin
  Scenario:Loging with valid credential
    Given the user is on the login page
    When  the user enter correct username
    And the user enter valid password
    And the user click the login button
    Then the user should be able to login


