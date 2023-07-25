package com.bignerdranch.android.blognerdranch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import com.bignerdranch.android.blognerdranch.repo.PostRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.bignerdranch.android.blognerdranch.model.Post

class PostViewModel : ViewModel() {

    private var postRepo: PostRepo = PostRepo()
    private var postMetaDataMutableLiveData = MutableLiveData<List<PostMetadata>>()
    private var postMutableLiveData = MutableLiveData<Post>()

    fun getPostMetaDataListResponse(): MutableLiveData<List<PostMetadata>>{
        postRepo.getPostMetaDataList().enqueue(object : Callback<List<PostMetadata>>{
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

    fun getPostResponse(postID: Int): MutableLiveData<Post>{
        postRepo.getPost(postID).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                postMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
            }
        })

        return postMutableLiveData
    }


}