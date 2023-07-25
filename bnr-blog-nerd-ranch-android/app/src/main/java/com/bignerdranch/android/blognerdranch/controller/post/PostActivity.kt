package com.bignerdranch.android.blognerdranch.controller.post

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.PostResponse
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.adapter.BlogAdapter
import com.bignerdranch.android.blognerdranch.adapter.Dummy
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.viewmodel.DummyViewModel
import com.bignerdranch.android.blognerdranch.viewmodel.PostBlogViewModel
import com.bignerdranch.android.blognerdranch.viewmodel.PostViewModel
import kotlinx.coroutines.launch

class PostActivity : AppCompatActivity() {

    private var postId: Int = 0

    private var postTitle: TextView? = null
    private var postAuthor: TextView? = null
//    private var postBody: TextView? = null
    private var postRecyclerView: RecyclerView? = null

    private lateinit var mAdapter: Dummy
    private val viewModel: DummyViewModel by viewModels()

    private lateinit var postBlogViewModel: PostBlogViewModel
    private lateinit var postBlogObserver: Observer<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postTitle = findViewById(R.id.title_textview)
        postAuthor = findViewById(R.id.author_textview)
//        postBody = findViewById(R.id.body_textView)
        postRecyclerView = findViewById(R.id.body_recyclerview)

        postId = intent.getIntExtra(EXTRA_POST_ID, 0)

        postBlogViewModel = ViewModelProvider(this).get(PostBlogViewModel::class.java)
        postBlogObserver = Observer { displayData -> updateUI(displayData) }
        postBlogObserver.let {
            postBlogViewModel.getPostCoroutine(postId).observe(this, it)
        }

        setUpAdapter()

//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:8106/") // "localhost" is the emulator's host. 10.0.2.2 goes to your computer
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val blogService = retrofit.create(BlogService::class.java)
//
//        val postRequest = blogService.getPost(postId)
//        postRequest.enqueue(object: Callback<Post?> {
//            override fun onFailure(call: Call<Post?>, t: Throwable) {
//                Log.e(TAG, "Failed to load post", t)
//            }
//
//            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
//                Log.i(TAG, "Loaded post $response")
//                updateUI(response.body()!!)
//            }
//        })

    }

    private fun updateUI(post: Post) {
        postTitle?.text = post.metadata?.title
        postAuthor?.text = post.metadata?.author?.name
//        postBody?.text = post.body

        postRecyclerView?.layoutManager = LinearLayoutManager(this)
        postRecyclerView?.adapter = post.body?.let { BlogAdapter(it) }
    }


    private fun setUpAdapter(){
        mAdapter = Dummy()
        postRecyclerView?.layoutManager = LinearLayoutManager(this)
        postRecyclerView?.adapter = mAdapter
    }


    companion object {
        const val TAG = "PostActivity"

        const val EXTRA_POST_ID = "postID"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra(EXTRA_POST_ID, id)
            return intent
        }
    }

}
