package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.R
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.databinding.ActivityNotificationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class NotificationActivity:AppCompatActivity() {

    lateinit var notificationViewModel: NotificationViewModel

    lateinit var activityNotificationBinding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNotificationBinding=DataBindingUtil.setContentView(this, R.layout.activity_notification)
        notificationViewModel=ViewModelProvider(this)[NotificationViewModel::class.java]
        activityNotificationBinding.notificationModel=notificationViewModel
        activityNotificationBinding.lifecycleOwner=this

        initView()
    }


    private fun initView()
    {

        val notificationAdapter=NotificationAdapter()

        activityNotificationBinding!!.RvView.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = notificationAdapter
        }

        lifecycleScope.launchWhenCreated {
            notificationViewModel.getNotificationList.collectLatest {
                    event ->
                notificationAdapter.submitData(event)
            }
        }

        notificationAdapter.addLoadStateListener { loadState ->
            // show empty list
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading)
                activityNotificationBinding.PbBar.isVisible = true
            else {
                activityNotificationBinding.PbBar.isVisible = false
                // If we have an error, show a toast
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error ->  loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(this, it.error.toString(), Toast.LENGTH_LONG).show()
                }

            }
        }


    }
}