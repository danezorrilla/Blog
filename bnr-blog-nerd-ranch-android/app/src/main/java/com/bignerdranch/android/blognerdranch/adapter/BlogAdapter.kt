package com.bignerdranch.android.blognerdranch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.PostResponse
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.controller.list.PostViewHolder
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata

class BlogAdapter(var post: String) : RecyclerView.Adapter<PostBlogViewHolder>()  {

    override fun getItemCount(): Int {
        return post.length
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostBlogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_post, parent, false)
        return PostBlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostBlogViewHolder, position: Int) {
        val post = post
        holder.bind(post)
    }

}