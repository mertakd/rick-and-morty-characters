package com.androiddev.rickandmorty

import retrofit2.Response

data class SimpleResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception? //hata durumunda döner exeption yani istisna, success de dönmez.
) {

    companion object {
        fun <T> success(data: Response<T>): SimpleResponse<T> {
            return SimpleResponse(
                status = Status.Success,
                data = data,
                exception = null
            )
        }

        fun <T> failure(exception: Exception): SimpleResponse<T> {
            return SimpleResponse(
                status = Status.Failure,
                data = null,
                exception = exception
            )
        }
    }

    sealed class Status {
        object Success : Status()
        object Failure : Status()
    }




    //bu snıfa erişirken kullanabileceğimiz değişkenler
    val failed: Boolean
        get() = this.status == Status.Failure
    //yanıtın başarısız olup olmadığını kontrol edebiliriz.

    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true
    //newtwork(ağ) isteği başarılı olursa true dönüyor

    val body: T
        get() = this.data!!.body()!!
    //true döndükden sonra body ile verileri(response) alıyoruz

    val bodyNullable: T?
        get() = this.data?.body()
}