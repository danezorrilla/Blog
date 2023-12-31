package com.bignerdranch.android.blognerdranch.controller.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.viewmodel.PostViewModel

class PostListActivity : AppCompatActivity() {

    private var postRecyclerView: RecyclerView? = null

    private lateinit var postViewModel: PostViewModel
    private lateinit var postObserver: Observer<List<PostMetadata>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        postRecyclerView = findViewById(R.id.post_recyclerview)
        postRecyclerView?.layoutManager = LinearLayoutManager(this)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postObserver = Observer { postMetaData -> displayPostMetaDataList(postMetaData) }
        postObserver.let {
            postViewModel.getPostMetaDataListResponse().observe(this, it)
        }

//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:8106/") // "localhost" is the emulator's host. 10.0.2.2 goes to your computer
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val blogService = retrofit.create(BlogService::class.java)
//
//        val postMetadataRequest = blogService.getPostMetadata()
//        postMetadataRequest.enqueue(object: Callback<List<PostMetadata>?> {
//            override fun onFailure(call: Call<List<PostMetadata>?>, t: Throwable) {
//                Log.e(TAG, "Failed to load postMetadata", t)
//            }
//
//            override fun onResponse(call: Call<List<PostMetadata>?>, response: Response<List<PostMetadata>?>) {
//                Log.i(TAG, "Loaded postMetadata $response")
//                postRecyclerView?.adapter = PostAdapter(response.body()!!)
//            }
//        })

    }

    private fun displayPostMetaDataList(postMetadata: List<PostMetadata>){
        for (index in postMetadata.indices){
            postRecyclerView?.adapter = PostAdapter(postMetadata)
        }
    }

    companion object {
        const val TAG = "PostListActivity"
    }
}
