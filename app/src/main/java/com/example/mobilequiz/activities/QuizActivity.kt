package com.example.mobilequiz.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilequiz.R
import com.example.mobilequiz.helpers.getJsonDataFromAsset
import com.example.mobilequiz.models.QuestionListModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class QuizActivity : AppCompatActivity() {

    private var timerProgressBar: ProgressBar? = null
    private var buttonOption1: Button? = null
    private var buttonOption2: Button? = null
    private var buttonOption3: Button? = null
    private var buttonOption4: Button? = null
    private var questionTextView: TextView? = null
    private var questions: ArrayList<QuestionListModel> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setupViews()
        setupDataSource()
        getNewQuestion()
    }
    override fun onStart() {
        super.onStart()
        countTimer()
    }
    private fun setupViews() {
        buttonOption1 = findViewById(R.id.button)
        buttonOption2 = findViewById(R.id.button2)
        buttonOption3 = findViewById(R.id.button3)
        buttonOption4 = findViewById(R.id.button4)
        questionTextView = findViewById(R.id.questionTextView)
        timerProgressBar = findViewById(R.id.progressBarTimer)
    }
    private fun getNewQuestion() {
//        refreshQuestion()
//        questionTextView?.text = questions?.first()?.questionValue
//        buttonOption1?.text = questions?.first()?.options?.first()?.optionValue
    }
    private fun refreshQuestion() {
//        val questionsCount =  if (questions != null) questions?.count() else 0
//        val randomIndex = Random.nextInt(range = 0..questionsCount!!)
//        val quizData = questions?.get(randomIndex)
//        val quiz = QuestionModel(
//            idQuestion = quizData!!.idQuestion,
//            questionValue = quizData!!.questionValue,
//            options = quizData!!.options, answer = quizData!!.answer
//        )
    }

    private fun setupDataSource() {
        val jsonFileString = getJsonDataFromAsset(fileName = "quizData.json", context = this.applicationContext)
        val typeListQuestion = object: TypeToken<ArrayList<QuestionListModel>>() {}.type
//        val questions: ArrayList<QuestionListModel> = Gson().fromJson(jsonFileString, typeListQuestion)
//        this.questions = questions
    }

    private fun countTimer() {
        var i = 0
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                i++
                timerProgressBar?.progress = i * 100 / (5000 / 1000)
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