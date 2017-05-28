package Lecture5_POM

import groovy.json.JsonSlurper
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Created by aleksandrs on 21/05/2017.
 */
class StaticContext extends StoreValue {

    static User getUser(String userAlias) {

        def user = get(userAlias) as User
        user
    }

    static storeUser(String userAlias, User user) {
        store(userAlias, user)
    }

    static ArrayList<Map> loadPredefinedUserData() {
        def predefinedUserJson = this.class.getResource(Configuration.PREDEFINED_USER_JSON_PATH)
        def predefinedUserJsonText = predefinedUserJson.text
        def jsonText = new JsonSlurper().parseText(predefinedUserJsonText) as Map
        ArrayList<Map> userList = jsonText.users as ArrayList
        userList
    }

//    static User getPredefinedUser(String userAlias) {
//        Map userData = predefinedUserList.find { Map user -> userAlias == user.alias as String }
//        if (userData != null) {
//            User user = new User()
//            user.userfullName = userData.userfullName
//            user.password = userData.password == null ? Configuration.DEFAULT_PASSWORD : userData.password as String
//            user.fullName = userData.fullName
//            user.email = userData.email
//            user.birthDate = DateTime.parse(userData.birthDate as String, DateTimeFormat.forPattern("dd.MM.yyyy"))
//            user.socialUsername = userData.socialUsername
//            user.socialPassword = userData.socialPassword
//            storeUser(userAlias, user)
//            println "\nFound predefined user: Created $userAlias as predefined user ${user.username}!\n"
//            return user
//        } else {
//            return null
//        }
//    }

}
