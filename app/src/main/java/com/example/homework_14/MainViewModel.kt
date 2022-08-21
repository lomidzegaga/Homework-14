package com.example.homework_14

import androidx.lifecycle.ViewModel
import com.example.homework_14.api.RetrofitClient
import com.example.homework_14.model.MainDataClass
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    fun getItems(): Flow<Result<MainDataClass.Content>> = flow {
        val answerFromServer = RetrofitClient.retrofitBuilder.items()
        val response: Result<MainDataClass.Content> = when {
            answerFromServer.isSuccessful -> {
                Result.Success(list = answerFromServer.body()!!.content)
            }

            else -> {
                Result.Error(errorMsg = answerFromServer.errorBody()!!.string())
            }
        }

        emit(response)
    }

}

sealed class Result<T> {
    data class Success<T>(val list: List<T>) : Result<T>()
    data class Error<T>(val errorMsg: String) : Result<T>()
}