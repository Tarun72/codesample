package com.codechanllenge.auth.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codechanllenge.auth.AuthRepository
import com.codechanllenge.auth.model.Login
import com.codechanllenge.auth.presenter.AuthPresenter
import javax.inject.Inject
import kotlin.math.log

class AuthViewModel @Inject
constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    private val TAG = "AuthViewModel"

    @Inject
    lateinit var authPresenter: AuthPresenter
    var login: Login = Login("", "")

    var errorLiveData: MutableLiveData<String> = MutableLiveData()
    var activeLoginLiveData: MutableLiveData<Boolean> = MutableLiveData()


    fun login() {
        if (login.isLoginEnable) {
            // activate
        }
    }


    fun afterUserNameChange(s: CharSequence) {
        val username = s.toString()
        Log.d(TAG, "afterUserNameChange: $username")
        val isValid = authPresenter.isUserNameValid(username)
        if (isValid == AuthPresenter.AuthError.invalidUserName()) {
            logError(isValid, username, login.password)
        } else {
            initLogin(userName = username, login.password)
        }
    }

    fun afterPasswordChange(s: CharSequence) {
        val password = s.toString()
        Log.d(TAG, "afterPasswordChange: $password")
        val isValid = authPresenter.isPasswordValid(password)
        if (isValid == AuthPresenter.AuthError.invalidPassword()) {
            logError(isValid, login.userName, password)
        } else {
            initLogin(userName = login.userName, password)

        }
    }

    fun initLogin(userName: String, password: String) {
        Log.d(TAG, "initLogin: ${login}")
        if (userName.isNotEmpty()) {
            login.userName = userName
        }
        if (password.isNotEmpty()) {
            login.password = password
        }
        val isActive = authPresenter.activeLoginButton(login)
        activeLoginLiveData.postValue(isActive)
    }

    fun logError(isValid: String, userName: String, password: String) {
        // set Error
        errorLiveData.value = isValid
        login.isLoginEnable = false
        if (userName.isNotEmpty()) {
            login.userName = userName
        }
        if (password.isNotEmpty()) {
            login.password = password
        }
        activeLoginLiveData.postValue(false)
    }
}