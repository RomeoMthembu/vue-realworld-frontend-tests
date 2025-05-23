Feature: Registration of a new Customer

  Scenario: : Customer registers with valid credentials

    Given  A new customer launches the Website
    When  Customer registers with valid credentials on the website
    Then  Customer must be able to register successfully

  Scenario: Customer registers with existing email credentials

    Given  A new customer launches the Website
    When  Customer registers using existing email address
    Then  An invalid registration credentials error must be displayed

  Scenario: User registers with an invalid email address

    Given  A new customer launches the Website
    When  User attempts to register with an invalid email
    Then A email validation error must be displayed