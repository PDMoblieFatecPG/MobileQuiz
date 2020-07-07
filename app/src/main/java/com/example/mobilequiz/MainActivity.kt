package com.example.mobilequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val viewHolder = ViewHolder.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }
    fun setupViews() {
        viewHolder.buttonQuiz = findViewById<Button>(R.id.startQuizButton)
    }
}
class ViewHolder {
    var buttonQuiz: Button? = null

    companion object Instance {
        fun create(): ViewHolder = ViewHolder()
    }
}