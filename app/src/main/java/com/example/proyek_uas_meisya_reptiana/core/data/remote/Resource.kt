package com.example.proyek_uas_meisya_reptiana.core.data.remote

sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): Resource<T>(data)
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
