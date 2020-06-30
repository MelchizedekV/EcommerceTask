package com.example.ecommercetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         callProductListScreen()
    }

    private fun callProductListScreen() {

        CoroutineScope(Dispatchers.Main).
                launch {

                    delay(5000)
            val callProductList = Intent(this@MainActivity,ProductList::class.java)
            startActivity(callProductList)
            finish()
        }



    }
}
