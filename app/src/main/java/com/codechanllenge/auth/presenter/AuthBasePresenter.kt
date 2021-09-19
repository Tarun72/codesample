package com.codechanllenge.auth.presenter

import com.codechanllenge.auth.model.Login
import com.codechanllenge.base.BasePresenter

interface AuthBasePresenter : BasePresenter {
    fun isUserNameValid(userName: String): String
    fun isPasswordValid(userName: String): String
    fun activeLoginButton(login: Login): Boolean
}