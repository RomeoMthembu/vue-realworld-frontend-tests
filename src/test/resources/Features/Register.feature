Feature: Registration of a new Customer

  Scenario: : Customer registers with valid credentials

    Given  A new customer
    When  Customer registers with valid credentials on the website
    Then  Customer must be able to register successfully