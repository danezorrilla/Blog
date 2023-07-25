package com.bignerdranch.android.blognerdranch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post

class Dummy() : PagingDataAdapter<Post, PostBlogViewHolder>(PostComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostBlogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_post, parent, false)
        return PostBlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostBlogViewHolder, position: Int) {
        val post = getItem(position)

        post?.body?.let { holder.bind(it) }
    }
}