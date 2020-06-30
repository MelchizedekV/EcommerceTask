package com.example.ecommercetask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    var BASE_URL:String="https://www.mocky.io/v2/"

    val getClient: APIInterface
        get() {

            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(APIInterface::class.java)

        }

}

