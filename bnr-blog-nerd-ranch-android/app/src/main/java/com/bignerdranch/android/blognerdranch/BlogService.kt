package com.bignerdranch.android.blognerdranch

import androidx.paging.DataSource
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BlogService {

    @GET("post-metadata")
    fun getPostMetadata(): Call<List<PostMetadata>>

    @GET("post/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Post>

    @GET("post/{id}")
    suspend fun getPostPage(@Path("id") id: Int): Response<PostResponse>

    @GET("post/{id}")
    fun getPostID(@Path("id") id: Int): Call<Post>


//    @GET("post/{id}")
//    suspend fun getPost(@Query("query") query: Int,
//                @Query("page") page: Int,
//                @Query("per_page") perPage: Int): PostResponse

    companion object{
        fun getInstance(): BlogService{
            return  Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8106/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BlogService::class.java)
        }
    }
}