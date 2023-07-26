package com.bignerdranch.android.blognerdranch.controller.post

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.paging.MainAdapter
import com.bignerdranch.android.blognerdranch.viewmodel.BlogViewModel
import com.bignerdranch.android.blognerdranch.viewmodel.PostViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PostActivity : AppCompatActivity() {

    private var postId: Int = 0

    private var postTitle: TextView? = null
    private var postAuthor: TextView? = null
//    private var postBody: TextView? = null

    private var postRecyclerView: RecyclerView? = null
    private lateinit var mAdapter: MainAdapter

    private lateinit var postViewModel: PostViewModel
    private lateinit var blogViewModel: BlogViewModel
    private lateinit var postBlogObserver: Observer<Post>

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_post)

//        postTitle = findViewById(R.id.title_textview)
//        postAuthor = findViewById(R.id.author_textView)
//        postBody = findViewById(R.id.body_textView)
//        postRecyclerView = findViewById(R.id.body_recyclerview)

        postRecyclerView = findViewById(R.id.main_recyclerview)

        progressBar = findViewById(R.id.progress_bar)

        postId = intent.getIntExtra(EXTRA_POST_ID, 0)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        blogViewModel = ViewModelProvider(this).get(BlogViewModel::class.java)

//        postBlogObserver = Observer { displayData -> updateUI(displayData) }
//        postBlogObserver.let {
//            postViewModel.getPostCoroutine(postId).observe(this, it)
//        }

        displayPagePost(postId)

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
        postRecyclerView?.adapter = post.body?.let { PostBlogAdapter(it) }
    }

    private fun displayPagePost(postID: Int){
        mAdapter = MainAdapter()
        postRecyclerView?.layoutManager = LinearLayoutManager(this)
        postRecyclerView?.adapter = mAdapter

        lifecycleScope.launch {
            blogViewModel.getPostPage(postID).collectLatest{
                it.let {
                    mAdapter.submitData(it)
                }
            }
        }

//        mAdapter.addLoadStateListener { loadState ->
//            if (loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading)
//                showProgressBar(true)
//            else
//                showProgressBar(false)
//
//            val errorState = when {
//                loadState.append is LoadState.Error -> loadState.append as LoadState.Error
//                loadState.prepend is LoadState.Error ->  loadState.prepend as LoadState.Error
//                loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
//                else -> null
//            }
//
//            errorState?.let {
//                Toast.makeText(this, it.error.toString(), Toast.LENGTH_LONG).show()
//            }
//
//        }

    }

    private fun showProgressBar(boolean: Boolean){

        if (!boolean){
            progressBar.visibility = View.GONE
        } else {
            progressBar.visibility = View.VISIBLE
        }

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
