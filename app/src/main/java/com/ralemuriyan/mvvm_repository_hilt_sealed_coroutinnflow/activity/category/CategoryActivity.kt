package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.R
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant.ResultResource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class CategoryActivity:AppCompatActivity() {


    lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        categoryViewModel=ViewModelProvider(this)[(CategoryViewModel::class.java)]


        lifecycleScope.launchWhenStarted {

            categoryViewModel.getCategoryResponse.collect{ value->

                when(value)
                {
                    is ResultResource.Loading ->
                    {
                        Log.e("Loading","True")
                    }

                    is ResultResource.ErrorMessage ->
                    {
                        Log.e("ErrorMessage","True")
                    }

                    is ResultResource.Success ->
                    {
                        Log.e("Success",value.data!!.info.toString())
                    }
                }

            }

        }


    }
}