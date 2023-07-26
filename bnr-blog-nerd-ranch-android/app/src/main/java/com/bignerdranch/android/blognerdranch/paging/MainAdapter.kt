package com.bignerdranch.android.blognerdranch.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post

class MainAdapter : PagingDataAdapter<Post, MainAdapter.MainViewHolder>(PostComparator) {

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.main_title_textview)
        var author: TextView = itemView.findViewById(R.id.main_author_textview)
        var body: TextView = itemView.findViewById(R.id.main_body_textview)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = getItem(position)?.metadata?.title
        holder.author.text = getItem(position)?.metadata?.author?.name
        holder.body.text = getItem(position)?.body
        holder.setIsRecyclable(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_blog, parent, false)
        return MainViewHolder(view)
    }
}