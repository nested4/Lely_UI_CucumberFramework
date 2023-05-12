Feature: Lely Tech Docs

  Scenario: Verify document download functionality
    Given User is on the Lely Tech Docs page
    When User selects "LUNA EUR" from the dropdown
    Then User should be able to see the catalogs
    When User views the document
    Then the document should open in a new tab
    When User returns to the previous tab and download the document
    Then the document should be downloaded