package com.example.daggerhiltapplication.Repository

import com.example.daggerhiltapplication.model.Post
import com.example.daggerhiltapplication.network.PostApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val postApiService: PostApiService){

    fun getPost(): Flow<List<Post>> = flow{
        val response = postApiService.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)
}