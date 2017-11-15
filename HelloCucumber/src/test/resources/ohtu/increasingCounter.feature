Feature: As a user I want to be able to increase the counter value

  Scenario: Increment once
    Given Counter is initialized
    When it is incremented
    Then the value should be 1

  Scenario: Increment by many
    Given Counter is initialized
    When it is incremented by 5
    Then the value should be 5

  Scenario: Increment many times
    Given Counter is initialized
    When it is incremented
    And it is incremented
    And it is incremented
    Then the value should be 3

  Scenario: Reseting after one increment
    Given Counter is initialized
    When it is incremented
    And it is reseted
    Then the value should be 0

  Scenario: Reseting after incrementing with several values
    Given Counter is initialized
    When it is incremented by 5
    And it is reseted
    Then the value should be 0
