package com.fcenesiz.handleerrors.domain

import com.fcenesiz.handleerrors.data.MyRepositoryImpl
import com.fcenesiz.handleerrors.util.Resource

class SubmitEmailUseCase(
    private val repository: MyRepository = MyRepositoryImpl()
) {

    suspend fun execute(email: String): Resource<Unit> {
        if (!email.contains("@")) {
            return Resource.Error("That is not a valid email")
        }
        return repository.submitEmail(email)
    }

}