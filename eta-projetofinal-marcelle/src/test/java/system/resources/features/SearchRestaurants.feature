@search
Feature:  Search restaurants

  Scenario: Search restaurants from a specific location
    Given User is in Uber Eats main page without a location set
    When User fill in location field with "<location>"
    And User clicks on Search button
    Then The location is set to "<location>"
    And List of restaurants are displayed
    Examples:
      | location |
      | Olinda  |
      | Casa de Noca  |