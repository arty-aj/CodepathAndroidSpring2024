package com.example.codepathandroidspring2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val restartButton = findViewById<Button>(R.id.restartButton)
        val answer = FourLetterWordList.getRandomFourLetterWord()
        val tvAnswer = findViewById<TextView>(R.id.TvAnswer)
        tvAnswer.text = "Word is: $answer"
        var count = 0

        //User has 3 chances to press button, after 3 presses, ask to restart
        submitButton.setOnClickListener {
            count++
            Toast.makeText(it.context, "Submit button clicked $count", Toast.LENGTH_SHORT).show()

            //Run checker code

            if(count >= 3){
                restartButton.visibility = View.VISIBLE
                tvAnswer.visibility = View.VISIBLE
                restartButton.setOnClickListener {
                    //Restart game
                    count = 0
                    restartButton.visibility = View.INVISIBLE
                    submitButton.visibility = View.VISIBLE
                    tvAnswer.visibility = View.INVISIBLE
                    tvAnswer.text = FourLetterWordList.getRandomFourLetterWord()
                }
            }
        }
    }
}