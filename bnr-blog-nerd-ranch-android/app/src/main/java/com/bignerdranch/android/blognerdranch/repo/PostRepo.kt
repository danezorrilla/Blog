package com.bignerdranch.android.blognerdranch.repo

import com.bignerdranch.android.blognerdranch.BlogService
import com.bignerdranch.android.blognerdranch.PostResponse
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import kotlinx.coroutines.flow.produceIn
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepo {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8106/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: BlogService = retrofit.create(BlogService::class.java)

    fun getPostMetaDataList(): Call<List<PostMetadata>>{
        return api.getPostMetadata()
    }

//    suspend fun getPostList(id: Int): Response<Post> {
//        return api.getPost(id)
//    }

        fun getPost(id: Int): Call<Post> {
        return api.getPostID(id)
    }


//    fun getPostResult(query: Int) =
//        Pager(
//            config = PagingConfig(
//                pageSize = 20,
//                maxSize = 100,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = { PostPagingSource(api, query) }
//        ).liveData
}