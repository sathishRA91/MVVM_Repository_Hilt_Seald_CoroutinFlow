package com.ralemuriyan.mvvm_repository_hilt_sealed_coroutinnflow.constant


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidationTest{

    @Test
    fun loginNameTest()
    {
        val result=Validation.nameValidation("122")

       assertThat(result).isTrue()
    }

   @Test
    fun passwordTest()
    {
        val result=Validation.passValidation("1")

        assertThat(result).isTrue()
    }
}