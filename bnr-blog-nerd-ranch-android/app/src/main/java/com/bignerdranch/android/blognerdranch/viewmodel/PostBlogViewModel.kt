package com.bignerdranch.android.blognerdranch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.blognerdranch.BlogService
import com.bignerdranch.android.blognerdranch.PostResponse
import com.bignerdranch.android.blognerdranch.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PostBlogViewModel : ViewModel() {

    private var api = BlogService.getInstance()
    private var postMutableLiveData = MutableLiveData<Post>()

    fun getPostCoroutine(postID: Int): MutableLiveData<Post>{
        viewModelScope.launch(Dispatchers.IO){
            val response = api.getPost(postID)
            if (response.isSuccessful){
                Log.d("TAG", "Response: " + response.body())
                postMutableLiveData.postValue(
                    response.body()
                )
            }
        }
        return postMutableLiveData
    }

}