package com.bignerdranch.android.blognerdranch.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bignerdranch.android.blognerdranch.model.Post

object PostComparator: DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}