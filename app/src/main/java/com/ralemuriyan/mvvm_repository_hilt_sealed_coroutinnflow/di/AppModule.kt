package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.di

import android.os.Build
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.login.LoginModel
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor {chain ->
                val authorisedRequest = chain.request().newBuilder()
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMjBlZDE5OWNiY2FiOTgzZWJhYzgwYzFmMTViYzU3Y2UzZWM1NGY2Mzc5NDUxMWY0YWRkNTE0ODAzMTc3MjViODVkZjkxYjM5Yjc4ZDIyZWMiLCJpYXQiOjE2NTUwODQxNTksIm5iZiI6MTY1NTA4NDE1OSwiZXhwIjoxNjg2NjIwMTU5LCJzdWIiOiI0OTNmODUwNC00YjkzLTQyNzctYTYxNi0xYTgyYmM5YzIwN2EiLCJzY29wZXMiOltdfQ.AKNu_FPQPjJwmXbAF3wAHJIAZi24dm57k5WM6lWu0gbWucW3AsRB8ENU5XEeXEm2QPG5UipfEjKNmiapJdPuLKPO71jfEpw8RJ5As7pIRKslMV9sL8PJBhXvZBwUhv1ybJjfjhbUJMbJXV0ln-giFxW8LvFWL1ww4ZlFQCZ__Nk_onEf4HA76dmuYJES4-iMYNUZuJLHZxXOKXTTxOZQgP1dV6-w3KjptlKPrBYSkWK_b1l3Yt9l2dFtX8ypDrhHN2eohICrNsfzx2T5fwdvyDX03AlIVKALwaAif2QoWUek3vckwYkdH6zgY_lWg5wLtfu_vrSBiPbfbHbdNVrPWhR6wKzfLmVHz9uHUR-Vk6wNbB3XvyEginTJDvVS_9RgFPC-tq0Eg6t7wTii9EervcXsevZ-Lim-eZVTLk7XEaF6A5A4b6u1MQ8zYA9tVHwQwP3zRkYnhcpZDxRMaNyZw6daZVtTC0AMPnQa38mCBV0_UhxHGI5nrJo6ugVox66pOrJ9DSkBUf4e8ZroOVz66GdUX7ykrfIlBdUXke31pXhrJL6iacn-SNK-c2bHU1dbNU489j4OgS_HSS6gY65Xy8u962QvrWRwHE6Gy1CuVvtrWrcqXD43axekfcm-iXMeRcdSfXe-RBe3lggxQae6bIc5M3e9wXXripSpyrnEW1w")
                    .header("Content-Language", "en")
                    .header("type", "customer")
                    .header("platform","mobile")
                    .header("devicename", Build.MANUFACTURER
                            + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                            + " " + Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name)
                    .build()
                chain.proceed(authorisedRequest)
            }.connectTimeout(100L, TimeUnit.SECONDS)
            .readTimeout(100L, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://uat.askalan.com.my/api/v1/")
            .client(okHttpClient)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginModel():LoginModel{

        return LoginModel()
    }
}