package com.bignerdranch.android.blognerdranch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import com.bignerdranch.android.blognerdranch.repo.PostRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel: ViewModel() {

    private var postRepo: PostRepo = PostRepo()
    private var postMetaDataMutableLiveData = MutableLiveData<List<PostMetadata>>()
    private var postMutableLiveData = MutableLiveData<Post>()

    fun getPostMetaDataListResponse(): MutableLiveData<List<PostMetadata>>{
        postRepo.getPostMetaDataList().enqueue(object : Callback<List<PostMetadata>> {
            override fun onResponse(
                call: Call<List<PostMetadata>>,
                response: Response<List<PostMetadata>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    postMetaDataMutableLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<PostMetadata>>, t: Throwable) {

            }
        })

        return postMetaDataMutableLiveData
    }

//    fun getPostResponse(postID: Int): MutableLiveData<Post>{
//        postRepo.getPost(postID).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                postMutableLiveData.value = response.body()
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//            }
//        })
//
//        return postMutableLiveData
//    }

    fun getPostCoroutine(postID: Int): MutableLiveData<Post>{
        viewModelScope.launch(Dispatchers.IO){
            val response = postRepo.getPostList(postID)
            if (response.isSuccessful){
                postMutableLiveData.postValue(
                    response.body()
                )
            }
        }
        return postMutableLiveData
    }
}