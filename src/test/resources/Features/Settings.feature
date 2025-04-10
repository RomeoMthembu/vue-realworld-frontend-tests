Feature: Customer can access Settings and update credentials

  Scenario: User accessing Auth page without logging in

    Given A User that has not registered
    When  User launches Auth page ( Settings)
    Then  The user must not be able to access the auth page without being authenticated.