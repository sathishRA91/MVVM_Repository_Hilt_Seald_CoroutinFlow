package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category

import com.google.gson.annotations.SerializedName

class CategoryModel {

    @SerializedName("success")
    var success:Boolean?=null

    @SerializedName("message")
    var message:String?=""

    @SerializedName("info")
    var info:ArrayList<Info>?=null

    class Info
    {
        @SerializedName("id")
        var id:Int?=0

        @SerializedName("name")
        var name:String?=""

        @SerializedName("short_code")
        var short_code:String?=""

        @SerializedName("parent_id")
        var parent_id:Int?=null

        @SerializedName("unit_id")
        var unit_id:Int?=null

        @SerializedName("description")
        var description:String?=""

        @SerializedName("image")
        var image:String?=""

        @SerializedName("status")
        var status:Int?=0

        @SerializedName("deleted_at")
        var deleted_at:String?=""

        @SerializedName("external_url")
        var external_url:String?=""

        @SerializedName("created_at")
        var created_at:String?=""

        @SerializedName("updated_at")
        var updated_at:String?=""

        @SerializedName("isSelection")
        var isSelection:Boolean?=false

        override fun toString(): String {
            return name.toString()
        }

    }
}