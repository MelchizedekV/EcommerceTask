package com.example.ecommercetask

import android.app.Activity
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ecommercetask.SQLiteHelper.Companion.IMGURL
import com.example.ecommercetask.SQLiteHelper.Companion.PRICE
import com.example.ecommercetask.SQLiteHelper.Companion.PRODUCT_NAME
import com.example.ecommercetask.SQLiteHelper.Companion.QTY
import com.example.ecommercetask.SQLiteHelper.Companion.TABLE_NAME

class DbAdapter() {

    lateinit var sqLiteHelper:SQLiteHelper
    val DATABASE_VERSION = 2
    val DATABASE_NAME = "Shoppie"

    lateinit var activity:Activity

    constructor(activity: ProductList) : this() {
        this.activity =activity
        sqLiteHelper = SQLiteHelper(activity,DATABASE_NAME,null,DATABASE_VERSION)

    }
    constructor(activity: CartScreen) : this() {
        this.activity =activity
        sqLiteHelper = SQLiteHelper(activity,DATABASE_NAME,null,DATABASE_VERSION)

    }




    fun addToCart(
        productName: String,
        price: String,
        quantity: String,
        thumb: String
    ): Long {

        val sqLiteDatabase: SQLiteDatabase = sqLiteHelper.getWritableDatabase()
        val contentValues = ContentValues()
        contentValues.put(PRODUCT_NAME, productName)
        contentValues.put(PRICE, price)
        contentValues.put(QTY, quantity)
        contentValues.put(IMGURL, thumb)

        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues)
    }
    fun getFromCart(): Cursor? {
        val sqLiteDatabase: SQLiteDatabase = sqLiteHelper.getWritableDatabase()

        val columns = arrayOf<String>(
            PRODUCT_NAME,
            PRICE,
            QTY,
            IMGURL
        )
        return sqLiteDatabase.query(TABLE_NAME, columns, null, null, null, null, null)
    }

}