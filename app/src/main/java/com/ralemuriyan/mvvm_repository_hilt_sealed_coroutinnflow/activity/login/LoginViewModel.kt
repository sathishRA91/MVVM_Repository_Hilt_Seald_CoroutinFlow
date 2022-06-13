package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant.Validation
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    init {

    }

    var name = MutableStateFlow("")
    var password = MutableStateFlow("")


    fun validationClick(): Boolean {

      val validationResult = when {
            !Validation.nameValidation(name.value) -> {
                false
            }

            !Validation.passValidation(password.value) -> {
                false
            }

            else -> {
                true
            }
        }

        return validationResult
    }
}