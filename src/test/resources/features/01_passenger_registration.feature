# Author: Juan
  # Language: en

Feature: Passenger registration in FleetGuard360 Feature 3
  As a passenger,
  I want to register on the platform by providing my basic information,
  to access travel booking services

  Scenario: Successful user registration with valid data
    Given I am in the registration page
    When I am submit a valid form
    Then I can see the login page