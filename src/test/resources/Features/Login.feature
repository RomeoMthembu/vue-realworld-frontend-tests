Feature: Customer can login to website

  Scenario: Customer can successfully login to website with valid credentials

    Given  An existing customer
    When  Customer logs in with valid username and password
    Then  The customer must be successfully logged in