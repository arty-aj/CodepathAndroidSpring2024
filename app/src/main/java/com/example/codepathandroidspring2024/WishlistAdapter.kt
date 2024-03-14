package com.example.codepathandroidspring2024

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wish: List<Item>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    //Holds views
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val itemName: EditText
        private val itemCost: EditText
        private val itemURL: EditText
        init {
            itemName = itemView.findViewById(R.id.etItemName)
            itemCost = itemView.findViewById(R.id.etItemCost)
            itemURL = itemView.findViewById(R.id.etItemURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return wish.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}