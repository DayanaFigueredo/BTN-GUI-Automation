@Version:1.0
@Search
Feature: SearchRestaurant
  As a user at Domicilios.com web page
  I want to be able to search restaurants by address
  So that I can make a delivery request

  @Regression
   Scenario: Search by an exact Delivery Address
    Given an user selects "Cali" City and "Avenida" street type
    And the user fills the fields with the following valid information
      | Street | 1 |
      | Corner | 2 |
      | Number | 3 |
    When the user clicks on the Search button
    And confirm its location
    Then a list of restaurants for the desired location must be displayed

  Scenario: Search by an inexact Delivery Address
    Given an user selects "Armenia" City and "Carrera" street type
    And the user fills the fields with the following valid information
      | Street | 4 |
      | Corner | 5 |
      | Number | 6 |
    When the user clicks on the Search button
    Then the user must be able to confirm its location

