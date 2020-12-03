
Feature: adminpanel
  Tests for login to admin panel

  Scenario: Login to admin panel - positive

    Given login page is opened
    When I enter login admin and password admin
    Then I see administration panel and see lightcart copyright
