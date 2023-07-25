package com.bignerdranch.android.blognerdranch

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bignerdranch.android.blognerdranch.Constant.NETWORK_PAGE_SIZE
import com.bignerdranch.android.blognerdranch.model.Post
import retrofit2.HttpException
import java.io.IOException

class BlogPagingSource(private val service: BlogService) : PagingSource<Int, Post>() {

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val pageIndex = params.key ?: 1

        return try {

            val response = service.getPostPage(
                pageIndex
            )
            val responseData = mutableListOf<Post>()
            val post = response.body()?.results ?: emptyList()
            responseData.addAll(post)
            val nextKey =
                if (post.isEmpty()) {
                    null
                } else {
                    // By default, initial load size = 3 * NETWORK PAGE SIZE
                    // ensure we're not requesting duplicating items at the 2nd request
                    pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                }

            LoadResult.Page(
                data = responseData,
                prevKey = if (pageIndex == 1) null else pageIndex,
                nextKey = nextKey
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}