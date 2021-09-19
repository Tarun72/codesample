package com.codechanllenge.auth.model

data class Login(
    var userName: String,
    var password: String
) {
    var isLoginEnable: Boolean = false
}