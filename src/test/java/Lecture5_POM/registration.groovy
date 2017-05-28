package Lecture5_POM

import cucumber.api.DataTable
import cucumber.api.groovy.EN
import org.apache.commons.lang3.RandomStringUtils

/**
 * Created by aleksandrs on 01/05/2017.
 */
this.metaClass.mixin(EN);


When(~/^user tries to sign up in (.*) via email from: (.*)$/) { String webPage, String emailPage ->
    EmailPage.getEmail(emailPage)
    def randomAlphanumericPart = RandomStringUtils.randomAlphanumeric(7);
    def randomNumeric = RandomStringUtils.randomNumeric(8);
    MainPage.openWeb(webPage)
    MainPage.closePopupAds();
    MainPage.openRegistration();

    RegistrationPage.inputUsername("AUTO$randomAlphanumericPart")
    RegistrationPage.inputLastname("Smith $randomAlphanumericPart")
    //  RegistrationPage.inputEmail(EmailPage.getEmail(emailPage))
    RegistrationPage.inputPhone(randomNumeric);
    RegistrationPage.chooseJobCategory("Pārdošana")
    RegistrationPage.signUp()
}

When(~/^user registers an account$/) { ->
    MainPage.openRegistration();
    RegistrationPage.createAccount();
}

When(~/^user recovers password to his (.*)$/) { String email ->
    LoginPage.openPasswordRecovery()
    LoginPage.recoverPassword(email)
}

Then(~/^user is able to log in$/) { DataTable rawUserData ->
    LoginPage.logIn()
}

And(~/^user logs out$/) { ->
    UserDataPage.logOut()
}

And(~/^user verifies his email$/) { ->
    EmailPage.verifyEmail()
}

Then(~/^user is registered$/) { ->
    assert RegistrationConfirmationPage.userIsRegistered()
}


