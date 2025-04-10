Feature: Testing home page loads successfully

  Scenario: Verify page title is correctly displayed

    Given A user launches Conduit website
    When The page has fully loaded
    Then Verify the page title is correctly displayed



