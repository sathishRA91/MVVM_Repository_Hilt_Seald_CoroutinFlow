package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant

object Validation {


    fun nameValidation(name:String):Boolean
    {
        return name.length>2
    }

    fun passValidation(password:String):Boolean
    {
        return password.length>2
    }
}