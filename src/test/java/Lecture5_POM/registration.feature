Feature: user is able to recover a password

  Scenario: register an account and make password recovery
    When user tries to sign up in http://cv.lv via email from: https://10minutemail.com
    And user verifies his email
    Then user is registered
    And user logs out
    When user recovers password to his email
    Then user is able to log in
      | $email@inbox.lv | test12345 |