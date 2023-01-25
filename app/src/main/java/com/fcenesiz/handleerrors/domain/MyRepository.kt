package com.fcenesiz.handleerrors.domain

import com.fcenesiz.handleerrors.util.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}