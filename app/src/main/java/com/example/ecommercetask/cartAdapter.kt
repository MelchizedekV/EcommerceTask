package com.example.ecommercetask

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.cardsinglelay.view.*

class cartAdapter() : RecyclerView.Adapter<cartAdapter.ChildHolder>() {
    lateinit var cartListValues: MutableList<Product>
    lateinit var activity: Activity

    constructor(cartScreen: CartScreen, cartListValues: MutableList<Product>, b: Boolean) : this() {

        activity =cartScreen
        this.cartListValues =cartListValues
    }

    inner class ChildHolder(view: View) : RecyclerView.ViewHolder(view) {

        val prodName: TextView = view.cartprod_name
        val Prodprice: TextView = view.cartProdprice
       val prod_img: ImageView = view.cartprod_img
        val prodQuan: TextView = view.cartqty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        return ChildHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardsinglelay, parent, false))    }

    override fun getItemCount(): Int {
        return cartListValues.size
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {


        holder.prodName.text = cartListValues.get(position).name
        holder.Prodprice.text = cartListValues.get(position).price
        holder.prodQuan.text = cartListValues.get(position).special

        Picasso.get()
            .load(cartListValues.get(position).thumb)
            .into(holder.prod_img, object : Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {
                }
            })
    }

}