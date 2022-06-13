package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant


sealed class ResultResource<T>(val data:T?=null, val message:String?=null){

    class Success<T>(data: T?):ResultResource<T>(data)

    class ErrorMessage<T>(message: String?,data: T?=null):ResultResource<T>(data,message)

    class Loading<T>():ResultResource<T>()

}
