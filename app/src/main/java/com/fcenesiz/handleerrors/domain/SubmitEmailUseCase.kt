package com.fcenesiz.handleerrors.domain

import com.fcenesiz.handleerrors.R
import com.fcenesiz.handleerrors.data.MyRepositoryImpl
import com.fcenesiz.handleerrors.util.Resource
import com.fcenesiz.handleerrors.util.UiText
import javax.inject.Inject


class SubmitEmailUseCase @Inject constructor(
    private val repository: MyRepository
) {

    suspend fun execute(email: String): Resource<Unit> {
        if (!email.contains("@")) {
            return Resource.Error(UiText.StringResource(R.string.error_invalid_email))
        }
        return repository.submitEmail(email)
    }

}