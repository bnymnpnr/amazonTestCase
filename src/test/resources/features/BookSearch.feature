@wip
Feature: Book Search

  Background:
    When user Navigate to Amazon Website

  Scenario: Book Searching
    Then Users should be able to select Books options from drop down
    And  search for the book named Harry Potter and the Philosopher's Stone
    And Check if Book is a Best Seller or Not
    And Verify other author and book related information from the search page
    And Check if Book is available in the format of an Kindle Edition
    Then  Select the book and proceed towards Check Out
    And Select Create Your Amazon Account and verify all fields


