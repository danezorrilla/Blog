package com.bignerdranch.android.blognerdranch.repo

import com.bignerdranch.android.blognerdranch.BlogService
import org.junit.Assert.*

import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepoTest {

    private val instance: BlogService = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8106/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BlogService::class.java)

    @Test
    fun getPostMetaDataList() {
        val service = instance.getPostMetadata()
        assertNotNull(service)
    }

    @Test
    fun getPost() {
        val id = 1042
        val service = instance.getPostID(id)
        assertNotNull(service)
    }
}