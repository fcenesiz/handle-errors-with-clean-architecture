package com.fcenesiz.handleerrors.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainViewModel {

    var email by mutableStateOf("")
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun onEmailChanged(email: String){
        this.email = email
    }

}