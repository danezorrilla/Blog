package com.bignerdranch.android.blognerdranch.adapter

//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bignerdranch.android.blognerdranch.PostResponse
//import com.bignerdranch.android.blognerdranch.R
//import com.bignerdranch.android.blognerdranch.controller.list.PostViewHolder
//import com.bignerdranch.android.blognerdranch.model.Post
//import com.bignerdranch.android.blognerdranch.model.PostMetadata
//
//class PostBlogAdapter() :
//    PagingDataAdapter<Post, PostBlogViewHolder>(PostComparator) {
//
//    override fun onBindViewHolder(holder: PostBlogViewHolder, position: Int) {
//        val item = getItem(position)
//        if (item != null) {
//            holder.bind(item)
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostBlogViewHolder {
//        val view = LayoutInflater
//            .from(parent.context).inflate(R.layout.activity_post, parent, false)
//
//        return PostBlogViewHolder(view)
//    }
//
//}