Feature: Search Functionality
#  Create a Selenium project and prepare a test case with the given actions and expectations.
#A)
#1) Navigate to https://www.lely.com/en using chrome browser.
#2) Click the search button and verify search area appeared.
#3) Enter “happy” into the search area and click the search button.
#4) Verify that the descriptions of each of the search results contain the searched word.

  @wip
  Scenario: Verify search functionality
    Given User is on the Lely website
    When User clicks the search button
    Then the search area should appear
    When User enters "happy" into the search area and click the search button
    Then all search results should contain the keyword "happy"