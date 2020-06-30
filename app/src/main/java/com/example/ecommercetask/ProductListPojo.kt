package com.example.ecommercetask

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductListPojo {
    @SerializedName("products")
    @Expose
    var products: List<Product>? = null

}