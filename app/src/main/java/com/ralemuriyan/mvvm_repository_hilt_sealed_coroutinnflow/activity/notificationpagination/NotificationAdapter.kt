package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.databinding.ItemNotificationBinding

class NotificationAdapter:PagingDataAdapter<NotificationModel.Data,NotificationAdapter.NotificationViewHolder>(NotificationComparator) {


    object NotificationComparator:DiffUtil.ItemCallback<NotificationModel.Data>(){
        override fun areItemsTheSame(oldItem: NotificationModel.Data, newItem: NotificationModel.Data) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NotificationModel.Data, newItem: NotificationModel.Data) =
            oldItem == newItem

    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {

        val myNotificationItem = getItem(position)

        holder.itemNotificationBinding.notificationItemModel = myNotificationItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNotificationBinding.inflate(inflater, parent, false)
        return NotificationViewHolder(binding)
    }


    inner  class NotificationViewHolder(var itemNotificationBinding: ItemNotificationBinding):RecyclerView.ViewHolder(itemNotificationBinding.root) {


    }


}