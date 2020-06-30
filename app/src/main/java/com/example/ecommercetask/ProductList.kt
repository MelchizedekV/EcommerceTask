package com.example.ecommercetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_product_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var productListView:RecyclerView
    lateinit var adapter:ViewAdapter
    lateinit var shoppingcart:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        productListView = findViewById(R.id.productList)
        shoppingcart= findViewById(R.id.shoppingcart)
        getData()
        product_progressBar.visibility= View.VISIBLE
        shoppingcart.setOnClickListener {
            val callCartScreen = Intent(this@ProductList,CartScreen::class.java)
            startActivity(callCartScreen)
        }

    }
    private fun getData() {
        val call: Call<ProductListPojo> = APIClient.getClient.getProducts()
        call.enqueue(object : Callback<ProductListPojo> {

            override fun onResponse(call: Call<ProductListPojo>?, response: Response<ProductListPojo>?) {
                if (response != null) {
                    productListView.apply {
                        layoutManager = LinearLayoutManager(this@ProductList)
                        adapter = ViewAdapter(this@ProductList,response.body()?.products,false)
                        product_progressBar.visibility= View.GONE
                    }


                }

            }

            override fun onFailure(call: Call<ProductListPojo>?, t: Throwable?) {
                Log.i("Response","failure")
            }

        })
    }

}
