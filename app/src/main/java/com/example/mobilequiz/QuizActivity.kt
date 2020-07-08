package com.example.mobilequiz

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    var timerProgressBar: ProgressBar? = null
    var buttonOption1: Button? = null
    var buttonOption2: Button? = null
    var buttonOption3: Button? = null
    var questionTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setupViews()
    }
    private fun setupViews() {
        buttonOption1 = findViewById(R.id.button)
        buttonOption2 = findViewById(R.id.button2)
        buttonOption3 = findViewById(R.id.button3)
        questionTextView = findViewById(R.id.questionTextView)
        timerProgressBar = findViewById(R.id.progressBarTimer)
        countTimer()
    }

    private fun countTimer() {
        var i = 0
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i++;
                timerProgressBar?.progress = i as Int * 100 / (5000 / 1000)
            }
            override fun onFinish() {
                i++
                timerProgressBar?.progress = 100
                Toast.makeText(this@QuizActivity, "Tempo Esgotado!!", Toast.LENGTH_LONG).show()
            }
        }
        timer.start()
    }
}