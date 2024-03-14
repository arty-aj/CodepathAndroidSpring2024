package com.example.codepathandroidspring2024

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishes: List<Wish>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    //Holds views
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
         val itemName: TextView
         val itemCost: TextView
         val itemURL: TextView
        init {
            itemName = itemView.findViewById(R.id.tvItemName)
            itemCost = itemView.findViewById(R.id.tvItemCost)
            itemURL = itemView.findViewById(R.id.tvItemURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishlistView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(wishlistView)
    }

    override fun getItemCount(): Int {
        return wishes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes[position]
        holder.itemCost.text = wish.itemCost
        holder.itemName.text = wish.itemName
        holder.itemURL.text = wish.itemURL
    }
}