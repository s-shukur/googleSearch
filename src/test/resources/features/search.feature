Feature: Search for Ducks in Google

  @smoke
  Scenario Outline: As a user I should be able to search for "<item>"  in the Google

    Given user is on the Google landing page
    When user searches for the "<item>"
    Then user should see the "<item>" in the search results page

    Examples:
    | item  |
    | Ducks |
