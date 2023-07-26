package com.bignerdranch.android.blognerdranch.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bignerdranch.android.blognerdranch.BlogService
import com.bignerdranch.android.blognerdranch.model.Post
import retrofit2.HttpException
import java.io.IOException

class MainPagingSource(private val service: BlogService, val id : Int) : PagingSource<Int, Post>() {

    private val initialPageIndex: Int = 1

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val position = params.key ?: initialPageIndex

        return try {

            val response = service.getPost(id)
            val responseData = mutableListOf<Post>()
            val post = response.body()
            if (post != null) {
                responseData.add(post)
            }

            LoadResult.Page(
                data = responseData,
                prevKey = if (position == initialPageIndex) null else position - 1,
                nextKey = position.plus(1)
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}