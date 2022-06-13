package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.network.ApiInterface
import java.lang.Exception

class NotificationPagingSourceRepository(private val apiInterface: ApiInterface) :
    PagingSource<Int, NotificationModel.Data>() {


    override fun getRefreshKey(state: PagingState<Int, NotificationModel.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NotificationModel.Data> {

        return try {
            val pageNumber = params.key ?: 1

          val response=  apiInterface.getNotification("api-my-notifications?page=$pageNumber")

            LoadResult.Page(data = response.body()!!.info!!.data!!, prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = pageNumber + 1)
        } catch (e: Exception) {

            LoadResult.Error(e)
        }

    }

}