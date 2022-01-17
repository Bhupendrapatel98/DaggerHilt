package com.example.daggerhiltapplication.network

import com.example.daggerhiltapplication.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
   suspend fun getPost():List<Post>
}