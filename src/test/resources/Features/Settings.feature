Feature: Customer can access Settings and update credentials

  Scenario: User accessing Auth page without logging in

    Given  An unregistered user launches Auth page (Settings)
    When  User updates user details in settings page
    Then The user must not be update details without being registered