package com.bignerdranch.android.blognerdranch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bignerdranch.android.blognerdranch.BlogService
import com.bignerdranch.android.blognerdranch.paging.MainPagingSource

class BlogViewModel: ViewModel() {

    private var api = BlogService.getInstance()

    fun getPostPage(id: Int) = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        MainPagingSource(api, id)
    }.flow.cachedIn(viewModelScope)

}