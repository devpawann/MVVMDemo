package com.pawan.mvvmdemo.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email")email:String,
        @Field("password")passoword:String

    ):Any
}