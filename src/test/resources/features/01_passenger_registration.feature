# Author: Juan
  # Language: en

Feature: Passenger registration in FleetGuard360 Feature 3
  As a passenger,
  I want to register on the platform by providing my basic information,
  to access travel booking services

  Scenario: Successful user registration with valid data
    Given I am in the registration page
    When I am submit a valid form
      | firstName | lastName | username  | typeId | id     | phone         | email            | password | confirmPassword | acceptTerms |
      | Juan      | Santa    | juansanta | CE     | 110111 | +573001234567 | juan@domain.com  | juan123P | juan123P        | true        |
    Then I can see the login page

  Scenario: Attempted registration with an existing email address
    Given I am in the registration page
    When I am submitting a valid form with an existing email address
      | firstName | lastName | username  | typeId | id     | phone         | email               | password | confirmPassword | acceptTerms |
      | Jose      | Perez    | juanperez | CE     | 110112 | +573001234568 | usuario@dominio.com | jose123P | jose123P        | true        |
    Then I see "El email ya está registrado." floating message
    And I cannot create my account

  Scenario: Attempted registration with an invalid password
    Given I am in the registration page
    When I try to submit the form with an invalid password
      | firstName | lastName | username    | typeId | id     | phone         | email              | password | confirmPassword | acceptTerms |
      | Miguel    | Angel    | miguelangel | CE     | 110113 | +573001234569 | miguel@dominio.com | 1234     | 1234            | true        |
    Then I see "Mínimo 8 caracteres, incluye mayúscula, minúscula y dígito; sin espacios" error
    And I cannot create my account

  Scenario: Attempted registration without accepting the terms
    Given I am in the registration page
    When I try to register without accepting the terms
      | firstName | lastName | username  | typeId | id     | phone         | email           | password | confirmPassword | acceptTerms |
      | Ana       | Villa    | anavilla  | CE     | 110114 | +573001234570 | ana@dominio.com | anav123P | anav123P        | false       |
    Then I see an error that contains "Debes aceptar"
    And I cannot create my account