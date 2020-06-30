package com.example.ecommercetask

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

 class SQLiteHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {


   companion object {
        val TABLE_NAME = "cart"
        val PRODUCT_NAME = "productname"
        val PRICE = "price"
        val QTY = "qty"
        val IMGURL = "img"
    }

     val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + PRODUCT_NAME + " VARCHAR(255) ," + PRICE + " VARCHAR(225)," + QTY +" VARCHAR(255)," + IMGURL + " BLOB);"

     val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME


    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {

        sqLiteDatabase?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, p1: Int, p2: Int) {

        sqLiteDatabase?.execSQL(DROP_TABLE)
        onCreate(sqLiteDatabase)

    }

}