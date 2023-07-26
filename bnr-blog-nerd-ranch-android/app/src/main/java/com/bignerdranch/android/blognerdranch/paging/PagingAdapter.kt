package com.bignerdranch.android.blognerdranch.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post

class PagingAdapter(val post: Post) : RecyclerView.Adapter<PagingAdapter.MainViewHolder>()  {

    private lateinit var postList: List<Post>

    init {
        postList = listOf<Post>(post)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.main_title_textview)
        var author: TextView = itemView.findViewById(R.id.main_author_textview)
        var body: TextView = itemView.findViewById(R.id.main_body_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_blog, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = postList[position].metadata?.title
        holder.title.text = postList[position].metadata?.title
        holder.title.text = postList[position].metadata?.title
    }
}