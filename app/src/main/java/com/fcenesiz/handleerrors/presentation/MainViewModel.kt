package com.fcenesiz.handleerrors.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fcenesiz.handleerrors.domain.SubmitEmailUseCase
import com.fcenesiz.handleerrors.util.Resource
import com.fcenesiz.handleerrors.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val submitEmailUseCase: SubmitEmailUseCase
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var error by mutableStateOf<UiText?>(null)
        private set

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun submitEmail() {
        viewModelScope.launch {
            val result = submitEmailUseCase.execute(email)
            when (result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {
                    error = result.message
                }
            }
        }
    }

}