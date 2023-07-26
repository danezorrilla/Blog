package com.bignerdranch.android.blognerdranch.paging

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post

//class PagingAdapter(val post: Post) : RecyclerView.Adapter<PagingAdapter.MainViewHolder>()  {
//
//    private lateinit var postList: ArrayList<Post>
//
//    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        var title: TextView = itemView.findViewById(R.id.main_title_textview)
//        var author: TextView = itemView.findViewById(R.id.main_author_textview)
//        var body: TextView = itemView.findViewById(R.id.main_body_textview)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//}