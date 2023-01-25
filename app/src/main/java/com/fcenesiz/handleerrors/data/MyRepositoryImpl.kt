package com.fcenesiz.handleerrors.data

import com.fcenesiz.handleerrors.domain.MyRepository
import com.fcenesiz.handleerrors.util.Resource
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl: MyRepository {
    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if (Random.nextBoolean()){
            Resource.Success(Unit)
        }else{
            if (Random.nextBoolean()){
                Resource.Error("Server error")
            }else{
                Resource.Error("Not authenticated error")
            }
        }
    }
}