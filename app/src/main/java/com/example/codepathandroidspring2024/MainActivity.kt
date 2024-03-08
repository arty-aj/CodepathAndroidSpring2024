package com.example.codepathandroidspring2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var emails: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRecyclerView = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        emailsRecyclerView.adapter = adapter
        emailsRecyclerView.layoutManager = LinearLayoutManager(this)

    }


}