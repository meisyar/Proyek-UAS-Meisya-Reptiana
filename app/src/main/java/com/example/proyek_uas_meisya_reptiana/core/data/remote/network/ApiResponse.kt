package com.example.proyek_uas_meisya_reptiana.core.data.remote.network

sealed class ApiResponse<out R>{
    data class Success<out T>(val data: T): ApiResponse<T>()
    data class Error(val errorMessage: String): ApiResponse<Nothing>()
    object Empty: ApiResponse<Nothing>()
}
