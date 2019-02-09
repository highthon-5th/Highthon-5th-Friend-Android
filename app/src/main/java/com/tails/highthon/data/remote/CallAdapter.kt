package com.tails.highthon.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CallAdapter{
    private const val URL = ""
    var api: API

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        api = retrofit.create(API::class.java)
    }

    abstract class Res<T> : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            callback(response.code(), response.body())
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            fail(t.message.toString())
        }

        abstract fun callback(code: Int, body: T?)
        abstract fun fail(massage : String)
    }
}