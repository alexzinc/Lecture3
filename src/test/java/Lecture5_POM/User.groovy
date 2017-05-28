package Lecture5_POM

import org.joda.time.DateTime

/**
 * Created by aleksandrs on 21/05/2017.
 */
class User {

    private String firstName
    private String surName
    private String password
    private String email
    private String mobile

    String getfirstName() {
        return firstName
    }

    void setfirstName(String firstName) {
        this.firstName = firstName
    }

    String getsurName() {
        return surName
    }

    void setsurName(String surName) {
        this.surName = surName
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getmobile() {
        return mobile
    }

    void setmobile(String mobile) {
        this.mobile = mobile
    }

    @Override
    public String toString() {
        "User:{name:$surName,fullName:$firstName,password:$password,email:$email,mobile:$mobile}}"
    }
}
