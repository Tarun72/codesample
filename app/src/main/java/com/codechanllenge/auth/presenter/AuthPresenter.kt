package com.codechanllenge.auth.presenter

import com.codechanllenge.auth.model.Login
import java.util.regex.Pattern
import javax.inject.Inject

class AuthPresenter @Inject constructor() : AuthBasePresenter {
    private val userNamePattern: Pattern = Pattern.compile("^[a-zA-Z0-9]+\$")
    private val passwordPattern: Pattern = Pattern.compile("^[a-zA-Z0-9@!?_]+\$")

    class AuthError() {
        companion object {
            fun invalidUserName(): String = "Enter proper user name"
            fun invalidPassword(): String = "Password not meeting the criteria"
            fun none(): String = "None"
        }
    }

    override fun isUserNameValid(userName: String): String {
        if (userName.isBlank() || userName.isEmpty()) {
            return AuthError.invalidUserName()
        }
        if (userName.length < 2) {
            return AuthError.invalidUserName()
        }
        if (userNamePattern.toRegex().matches(userName)) {
            return AuthError.none()
        }
        return AuthError.invalidUserName()
    }

    override fun isPasswordValid(password: String): String {
        if (password.isBlank() || password.isEmpty()) {
            return AuthError.invalidPassword()
        }
        if (password.length < 5) {
            return AuthError.invalidPassword()
        }
        if (passwordPattern.toRegex().matches(password)) {
            return AuthError.none()
        }
        return AuthError.invalidPassword()
    }

    override fun activeLoginButton(login: Login): Boolean {
        if (isPasswordValid(password = login.password) == AuthError.invalidPassword()) {
            return false
        }
        if (isUserNameValid(userName = login.userName) == AuthError.invalidUserName()) {
            return false
        }
        return true
    }

}