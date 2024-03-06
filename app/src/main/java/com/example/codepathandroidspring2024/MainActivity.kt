package com.example.codepathandroidspring2024

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var answer = FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buttons and user guess edit text
        val submitButton = findViewById<Button>(R.id.submitButton)
        val restartButton = findViewById<Button>(R.id.restartButton)
        val etUserGuess = findViewById<EditText>(R.id.EtUserGuess)
        val tvAnswer = findViewById<TextView>(R.id.TvAnswer)
        tvAnswer.text = "$answer"
        var count = 0

        //Text views displaying their guesses and the checker results
        val (userGuess1, userGuess2, userGuess3)  = Triple(
            findViewById<TextView>(R.id.TvUserGuess1),
            findViewById<TextView>(R.id.TvUserGuess2),
            findViewById<TextView>(R.id.TvUserGuess3)
        )

        val arrayOfGuesses = arrayOf(userGuess1, userGuess2, userGuess3)

        val (userCheck1, userCheck2, userCheck3)  = Triple(
            findViewById<TextView>(R.id.TvUserCheck1),
            findViewById<TextView>(R.id.TvUserCheck2),
            findViewById<TextView>(R.id.TvUserCheck3)
        )
        val arrayOfGuessChecks = arrayOf(userCheck1, userCheck2, userCheck3)

        //User has 3 chances to press button, after 3 presses, ask to restart
        submitButton.setOnClickListener {
            count++
            val userGuess = etUserGuess.text.toString()
            val capText = userGuess.uppercase(Locale.getDefault())
            var checker = checkGuess(capText)
            if(checker == "OOOO"){
                //End game restart
                arrayOfGuesses[count-1].text = capText
                arrayOfGuessChecks[count-1].text = checker
                Toast.makeText(it.context, "Great job, press restart to go again!", Toast.LENGTH_SHORT).show()
                restartButton.visibility = View.VISIBLE
                tvAnswer.visibility = View.VISIBLE
                restartButton.setOnClickListener {
                    //Restart game
                    Toast.makeText(it.context, "New game started", Toast.LENGTH_SHORT).show()
                    count = 0
                    restartButton.visibility = View.INVISIBLE
                    submitButton.visibility = View.VISIBLE
                    tvAnswer.visibility = View.INVISIBLE
                    answer = FourLetterWordList.getRandomFourLetterWord()
                    tvAnswer.text = answer
                    for(guess in arrayOfGuesses.indices){
                        arrayOfGuesses[guess].text = ""
                    }
                    for(checks in arrayOfGuessChecks.indices){
                        arrayOfGuessChecks[checks].text = ""
                    }
                }
            }else{
                //Add the letters to the text views
                arrayOfGuesses[count-1].text = capText
                arrayOfGuessChecks[count-1].text = checker
            }

            if(count >= 3){
                restartButton.visibility = View.VISIBLE
                tvAnswer.visibility = View.VISIBLE
                restartButton.setOnClickListener {
                    //Restart game
                    count = 0
                    restartButton.visibility = View.INVISIBLE
                    submitButton.visibility = View.VISIBLE
                    tvAnswer.visibility = View.INVISIBLE
                    answer = FourLetterWordList.getRandomFourLetterWord()
                    tvAnswer.text = FourLetterWordList.getRandomFourLetterWord()
                    for(guess in arrayOfGuesses.indices){
                        arrayOfGuesses[guess].text = ""
                    }
                    for(checks in arrayOfGuessChecks.indices){
                        arrayOfGuesses[checks].text = ""
                    }
                }
            }
        }
    }


    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == answer[i]) {
                result += "O"
            }
            else if (guess[i] in answer) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}