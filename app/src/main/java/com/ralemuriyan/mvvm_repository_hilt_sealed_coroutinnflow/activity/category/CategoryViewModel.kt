package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.activity.login.LoginModel
import com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant.ResultResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepository: CategoryRepository,private val loginModel: LoginModel) :ViewModel()
{

    private var resultResponse= MutableStateFlow<ResultResource<CategoryModel>?>(null)


    val getCategoryResponse:StateFlow<ResultResource<CategoryModel>?> = resultResponse

    init {
        loadCategory()
    }



    fun loadCategory()
    {
        loginModel.loadCheck()

        resultResponse.value=ResultResource.Loading()

        viewModelScope.launch(Dispatchers.Main) {

            val result=categoryRepository.loadCategory()

            if(result.code()==200)
            {
                resultResponse.value=ResultResource.Success(result.body())
            }
            else
            {
                resultResponse.value=ResultResource.ErrorMessage(result.body()!!.message.toString())
            }


        }
    }

}