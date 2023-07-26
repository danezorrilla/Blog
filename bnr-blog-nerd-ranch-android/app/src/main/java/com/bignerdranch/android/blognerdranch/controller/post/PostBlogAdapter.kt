package com.bignerdranch.android.blognerdranch.controller.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R

class PostBlogAdapter(var post: String): RecyclerView.Adapter<PostBlogViewHolder>() {

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