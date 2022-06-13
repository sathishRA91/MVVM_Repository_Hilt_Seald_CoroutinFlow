package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.R
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category.CategoryActivity
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.notificationpagination.NotificationActivity
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    lateinit var activityLoginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding=DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel= ViewModelProvider(this)[LoginViewModel::class.java]
        activityLoginBinding.loginModel=loginViewModel
        activityLoginBinding.lifecycleOwner=this

        activityLoginBinding!!.BtClick.setOnClickListener {

           if(loginViewModel.validationClick())
           {
               startActivity(Intent(this,NotificationActivity::class.java))
           }

        }

    }
}