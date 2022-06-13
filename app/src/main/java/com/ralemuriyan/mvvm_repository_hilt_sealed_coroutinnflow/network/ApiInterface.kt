package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.network

import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category.CategoryModel
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination.NotificationModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET
    suspend fun getCategory(@Url urlName:String):Response<CategoryModel>

    @GET
    suspend fun getNotification(@Url urlName: String):Response<NotificationModel>

}