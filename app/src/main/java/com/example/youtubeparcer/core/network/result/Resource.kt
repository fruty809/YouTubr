package com.example.youtubeparcer.core.network.result

data class Resource<out  T>(
    val status: com.example.youtubeparcer.core.network.result.Status, val data:T?, val message:String?,
    val code:Int?) {
    companion object{
        fun <T> success(data:T?): Resource<T>{
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> loading():Resource<T> {
            return Resource(Status.LOADING, null, null, null)
        }
        fun <T> error(msg: String?, data: T?, code: Int?  ):Resource<T>{
            return Resource(Status.ERROR, data, msg, code )
        }
    }
}