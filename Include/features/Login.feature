#Author: your.email@your.domain.com
#Feature: List of scenarios.
@login
Feature: Login feature
  As a user, I want login and direct to portal

  @login1
  Scenario Outline: succes login with valid credenttial
    Given I navigate to login page
    When I enter username <username> and password <password>
    And I click sign in button
    Then I should be able to login successfully

    Examples: 
      | username | password   |
      | P93700   | Rose1998!! |
