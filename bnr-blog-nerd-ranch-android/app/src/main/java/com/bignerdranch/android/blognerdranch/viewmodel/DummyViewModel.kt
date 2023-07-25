package com.bignerdranch.android.blognerdranch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bignerdranch.android.blognerdranch.BlogPagingSource
import com.bignerdranch.android.blognerdranch.BlogService
import com.bignerdranch.android.blognerdranch.Constant

class DummyViewModel: ViewModel() {
    private var api = BlogService.getInstance()

    val listData = Pager(PagingConfig(Constant.NETWORK_PAGE_SIZE)) {
        BlogPagingSource(api)

    }.flow.cachedIn(viewModelScope)

}