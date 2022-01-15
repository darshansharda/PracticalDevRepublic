package com.devrepublic.practical.api

data class Resource<out T>(val status: Status, val data: T?, val msg: String) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, "Success")
        }

        fun <T> error(data: T?, msg: String): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, "loading")
        }

    }


}


enum class Status {
    SUCCESS, ERROR, LOADING
}