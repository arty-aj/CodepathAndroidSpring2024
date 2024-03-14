package com.example.codepathandroidspring2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemName = findViewById<EditText>(R.id.etItemName)
        val itemCost = findViewById<EditText>(R.id.etItemCost)
        val itemURL = findViewById<EditText>(R.id.etItemURL)

        val wish: MutableList<Wish> = ArrayList()

        val recyclerView = findViewById<RecyclerView>(R.id.RvWishlist)
        val submitButton = findViewById<Button>(R.id.btnSubmit)

        val adapter = WishlistAdapter(wish)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            if(itemName.text.toString().isEmpty() || itemCost.text.toString().isEmpty() || itemURL.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill out all text fields!", Toast.LENGTH_SHORT).show()
            }else{
                val newItemName = itemName.text.toString()
                val newItemCost = itemCost.text.toString()
                val newItemURL = itemURL.text.toString()

                val newWish = Wish(newItemName, newItemCost, newItemURL)
                wish.add(newWish)

                adapter.notifyDataSetChanged()

                itemName.text.clear()
                itemCost.text.clear()
                itemURL.text.clear()
            }
        }
    }

}