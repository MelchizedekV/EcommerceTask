package com.example.ecommercetask

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_single_lay.view.*


class ViewAdapter() : RecyclerView.Adapter<ViewAdapter.ChildHolder>() {

    lateinit var productlist: List<Product>
    lateinit var dbAdapter:DbAdapter
    lateinit var activity:Activity



    constructor( activity: ProductList, products: List<Product>?,iscartScreen: Boolean) : this() {
       if (products != null) {
           this.productlist = products
           this.activity = activity
           dbAdapter= DbAdapter(activity)

       }

    }

    inner class ChildHolder(view: View) : RecyclerView.ViewHolder(view) {

        val prodName: TextView = view.prod_name
        val Prodprice: TextView = view.Prodprice
        val prod_img: ImageView = view.prod_img
        val plusSign: TextView = view.plusSign
        val minusSign: TextView = view.minusSign
        val prodQuan: TextView = view.prodQuan
        val addbtn: TextView = view.addbtn

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        return ChildHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_single_lay, parent, false))
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        var quantity: Int = 0

        holder.prodName.text = productlist.get(position).name
        holder.Prodprice.text = productlist.get(position).price
        Picasso.get()
            .load(productlist.get(position).thumb)
            .into(holder.prod_img, object : Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {
                }
            })
              holder.addbtn.setOnClickListener {



                  val id = dbAdapter.addToCart(holder.prodName.text.toString(),holder.Prodprice.text.toString(),quantity.toString(),productlist.get(position).thumb.toString())

               if (id > 0)
                   Toast.makeText(activity,"Product added in the card",Toast.LENGTH_LONG).show()
                else
                   Toast.makeText(activity,"Failure",Toast.LENGTH_LONG).show()
           }

    holder.minusSign.setOnClickListener {
    if(!holder.prodQuan.text.toString().equals("0"))
        quantity =quantity-1
        holder.prodQuan.text=quantity.toString()
    }
        holder.plusSign.setOnClickListener {
            quantity =quantity+1
            holder.prodQuan.text=quantity.toString()
        }
    }

}