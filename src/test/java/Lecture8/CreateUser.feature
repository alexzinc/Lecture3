Feature: user is creating an account

  @test
  Scenario: User is creating an account
    Given  user opens http://qaguru.lv:8080/qa2/
    When user creates an account with following data:
      | fullname | Andrew             |
      | surname  | Butterly           |
      | mobile   | 22287645           |
      | email    | adwjoawd@dwadwa.lv |
      | Gender   | Male               |
      | Id       | 322                |
    Then account should be created with following data:
      | fullname | Andrew             |
      | surname  | Butterly           |
      | mobile   | 22287645           |
      | email    | adwjoawd@dwadwa.lv |
      | Gender   | Male               |
      | Id       | 322                |
    When user adds score with following data:
      | age     | 22      |
      | city    | Riga    |
      | country | Latvija |
      | kids    | 2       |
    Then score should be displayed

