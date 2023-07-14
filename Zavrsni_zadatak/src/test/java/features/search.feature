Feature: Search
  User should be able to use search box in order to find travel accommodation.

  @Smoke
  Scenario: Search for travel accommodation
  User should be able to use search box with valid inputs.

    Given user is on the booking home page
    When  user dismisses popup
    And user enters destination "Kopaonik"
    And user selects travel dates
    And user clicks passenger field leaving everything by default
    And user clicks on the search button
    Then user is redirected to the search results page


#    Dva koraka za odabir datuma koja bih koristila kad bi mi radila ona neuspesna metoda:
#    And user selects check in date "September 2023", "20"
#    And user selects check out date "October 2023", "03"