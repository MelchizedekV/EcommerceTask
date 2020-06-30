package com.example.ecommercetask

import android.graphics.Bitmap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Product {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("product_id")
    @Expose
    var productId: String? = null
    @SerializedName("sku")
    @Expose
    var sku: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("thumb")
    @Expose
    var thumb: String? = null
    @SerializedName("zoom_thumb")
    @Expose
    var zoomThumb: String? = null
    @SerializedName("options")
    @Expose
    var options: List<Any>? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null
    @SerializedName("images")
    @Expose
    var images: List<Any>? = null
    @SerializedName("price")
    @Expose
    var price: String? = null
    @SerializedName("special")
    @Expose
    var special: String? = null

}