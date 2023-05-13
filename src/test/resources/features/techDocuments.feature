Feature: Lely Technical Documents Features
#1) Navigate to https://www.lely.com/techdocs/ using chrome browser.
#2) Select “LUNA EUR” from the dropdown and verify that the catalogs can be seen.
#3) Firstly, view the document and verify that it is opened on a new tab.
#4) Then, return to the previous tab and download the document. Verify that it is
# downloaded.
@tech @wip
  Scenario: View and Download the target Document
    Given user navigates to "https://www.lely.com/techdocs/"
    When user selects "LUNA EUR" from the dropdown
    Then user should be able to see the catalogs
    When user views the document
    Then the document should be opened in a new tab
    When user return to the previous tab
    And user download the document
    Then the document should be downloaded