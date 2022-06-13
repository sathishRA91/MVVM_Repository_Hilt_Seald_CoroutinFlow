package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination

import com.google.gson.annotations.SerializedName

class NotificationModel {

    @SerializedName("success")
    var success: Boolean? = null

    @SerializedName("message")
    var message: String? = ""

    @SerializedName("info")
    var info: Info? = null

    class Info {
        @SerializedName("data")
        var data: ArrayList<Data>? = null
    }

    class Data {
        @SerializedName("id")
        var id: Int? = null

        @SerializedName("type")
        var type: String? = ""

        @SerializedName("notifiable_type")
        var notifiable_type: String? = ""

        @SerializedName("notifiable_id")
        var notifiable_id: String? = ""

        @SerializedName("created_at")
        var created_at: String? = ""

        @SerializedName("data")
        var data:NotificationData?=null

        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }
    }

    class NotificationData {
        @SerializedName("message")
        var message: String? = ""

        @SerializedName("avatar")
        var avatar: String? = ""

        @SerializedName("job_id")
        var job_id:String?=""

        @SerializedName("job_code")
        var job_code:String?=""

        @SerializedName("title")
        var title:String?=""

        @SerializedName("url")
        var url:String?=""
    }

}