package com.example.ecommercetask

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("5def7b172f000063008e0aa2")
    fun getProducts():Call<ProductListPojo>

}