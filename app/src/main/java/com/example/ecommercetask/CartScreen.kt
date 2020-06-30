package com.example.ecommercetask

import android.database.Cursor
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask.SQLiteHelper.Companion.IMGURL
import com.example.ecommercetask.SQLiteHelper.Companion.PRICE
import com.example.ecommercetask.SQLiteHelper.Companion.PRODUCT_NAME
import com.example.ecommercetask.SQLiteHelper.Companion.QTY
import kotlinx.android.synthetic.main.activity_cart_screen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartScreen : AppCompatActivity() {
    lateinit var cartList: RecyclerView
    lateinit var adapter:ViewAdapter
    lateinit var dbAdapter:DbAdapter
    var cursor: Cursor? = null
    var cartListValues: MutableList<Product> = mutableListOf()

    lateinit var sqLiteHelper:SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_screen)
        cartList = findViewById(R.id.cartList)
        dbAdapter=DbAdapter(this@CartScreen)
        progressBar.visibility = View.VISIBLE
        checkoutBtn.setOnClickListener {
            Toast.makeText(this@CartScreen,"Your purchase will be deliever soon..",Toast.LENGTH_LONG).show()
            finish()
        }


            retrieveCartData()




    }


    private fun retrieveCartData() {

        var productName:String
        var price:String
        var qty:String
        var imgURL:String

        var finalPrice:Int

        cursor = dbAdapter.getFromCart()
        cartListValues.clear()

        while (cursor!!.moveToNext()) {
            productName = cursor!!.getString(cursor!!.getColumnIndex(PRODUCT_NAME))
            price = cursor!!.getString(cursor!!.getColumnIndex(PRICE))
            qty = cursor!!.getString(cursor!!.getColumnIndex(QTY))

             imgURL = cursor!!.getString(cursor!!.getColumnIndex(IMGURL))
//            finalPrice = qty.toInt() * price.toInt()
            val productPojo = Product()
                    productPojo.name =productName
                    productPojo.special = qty
                    productPojo.price =price
                    productPojo.thumb = imgURL
//                    productPojo.special=qty
                    cartListValues.add(productPojo)
        }

        cartList.apply {
            layoutManager = LinearLayoutManager(this@CartScreen)
            adapter = cartAdapter(this@CartScreen,cartListValues,true)
            progressBar.visibility = View.GONE
        }


    }

}
