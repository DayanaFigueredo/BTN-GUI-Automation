@Version:1.0
@Login
Feature: Login
  As a user with an account in Domicilios.com web page
  I want to be able to sign in on my profile
  So that I can use my personal information for make a delivery request

  @Regression
  Scenario: Login with valid credentials
    Given a user clicks on the log in hyperlink
    And the user enters the valid credentials
    When the user clicks on the Log In button
    Then the user successfully logs in on the system
