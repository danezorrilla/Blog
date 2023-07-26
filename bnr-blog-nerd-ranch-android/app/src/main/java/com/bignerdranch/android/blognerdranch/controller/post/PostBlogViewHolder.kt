package com.bignerdranch.android.blognerdranch.controller.post

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import retrofit2.http.Body

class PostBlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var postBody: String? = null

//    val titleTextView: TextView = itemView.findViewById(R.id.title_textview)
//    val authorTextView: TextView = itemView.findViewById(R.id.author_textView)
    val bodyTextView: TextView = itemView.findViewById(R.id.post_blog_textview)

    fun bind(postBody: String) {
        this.postBody = postBody
//        titleTextView.text = post.metadata?.title
//        authorTextView.text = post.metadata?.author?.name
        bodyTextView.text = postBody
    }

}