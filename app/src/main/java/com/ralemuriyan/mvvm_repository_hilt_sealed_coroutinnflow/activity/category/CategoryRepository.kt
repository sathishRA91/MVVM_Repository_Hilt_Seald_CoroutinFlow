package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category

import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.network.ApiInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val apiInterface: ApiInterface){


    suspend fun loadCategory():Response<CategoryModel>{
       return withContext(Dispatchers.IO)
        {
            apiInterface.getCategory("api-parent-category-list")
        }
    }

}