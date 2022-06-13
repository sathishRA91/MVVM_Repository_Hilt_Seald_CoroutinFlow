package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant.ResultResource
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.network.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(private val apiInterface: ApiInterface):ViewModel()
{


    init {

    }

    val getNotificationList: Flow<PagingData<NotificationModel.Data>> =
        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { NotificationPagingSourceRepository(apiInterface) }
        ).flow.cachedIn(viewModelScope)
}