package Lecture8

import Lecture7_backendTesting.Model.Gender
import cucumber.api.DataTable
import cucumber.api.groovy.EN

this.metaClass.mixin(EN);

/**
 * Created by aleksandrs on 21/05/2017.
 */

When(~/^user opens (.*)$/) { String webPage ->
    MainQAPage.openMain(webPage)
}

When(~/^user creates an account with following data:$/) { DataTable rawUserInfo ->

    def credentials = rawUserInfo.asMap(String.class, String.class)

    MainQAPage.addUser()
    AddUserPage.inputName(credentials.name as String)
    AddUserPage.inputSurname(credentials.surname as String)
    AddUserPage.inputPhone(credentials.phone as String)
    AddUserPage.inputEmail(credentials.email as String)
    AddUserPage.chooseGender(Gender.valueOf((credentials.gender as String).toUpperCase()))
    AddUserPage.inputId(credentials.id as String)
    AddUserPage.createUser()
}

Then(~/^account should be created with following data:$/) { DataTable rawUserInfo ->
    def credentials = rawUserInfo.asMap(String.class, String.class)
    assert MainQAPage.nameIsDisplayed(credentials.name as String)
    assert MainQAPage.surnameIsDisplayed(credentials.surname as String)
    assert MainQAPage.inputPhoneIsDisplayed(credentials.phone as String)
    assert MainQAPage.inputEmailIsDisplayed(credentials.email as String)
    assert MainQAPage.chooseGenderIsDisplayed(credentials.gender as String)
    assert MainQAPage.inputIdIsDisplayed(credentials.id as String)
}

When(~/^user adds score with following data:$/) { DataTable rawUserScoreInfo ->
    def credentials = rawUserScoreInfo.asMap(String.class, String.class)
    ScorePage.addScore()
    ScorePage.inputAge(credentials.age as Integer)
    ScorePage.inputCity(credentials.city as String)
    ScorePage.inputCountry(credentials.country as String)
    ScorePage.inputChildrenCount(credentials.kids as Integer)
    ScorePage.submit()
}

Then(~/^score should be displayed$/) { ->
    assert MainQAPage.scoreIsDisplayed()
}