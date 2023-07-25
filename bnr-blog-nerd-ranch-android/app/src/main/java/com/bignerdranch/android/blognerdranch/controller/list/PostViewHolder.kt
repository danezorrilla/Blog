package com.bignerdranch.android.blognerdranch.controller.list

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import com.bignerdranch.android.blognerdranch.controller.post.PostActivity
import java.time.format.DateTimeFormatter

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var postMetadata: PostMetadata? = null

    val titleTextView: TextView = itemView.findViewById(R.id.Title)
    val authorTextView: TextView = itemView.findViewById(R.id.Author)
    val summaryTextView: TextView = itemView.findViewById(R.id.Summary)
    val publishDateTextView: TextView = itemView.findViewById(R.id.Publish_Date)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(postMetadata: PostMetadata) {
        this.postMetadata = postMetadata
        titleTextView.text = postMetadata.title
        authorTextView.text = postMetadata.author?.name
        summaryTextView.text = postMetadata.summary
        publishDateTextView.text = DateTimeConversion(postMetadata.publishDate)
    }

    override fun onClick(v: View) {
        val context = v.context
        context.startActivity(PostActivity.newIntent(v.context, postMetadata!!.postId!!))
    }

    fun DateTimeConversion(string: String?): String {
        val input = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val output = DateTimeFormatter.ofPattern("MM-dd-yyyy hh-mm-ss a")
        val date = input.parse(string)
        return output.format(date)
    }

}