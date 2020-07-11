package com.example.mobilequiz.models

import com.google.gson.annotations.SerializedName

data class QuestionListModel(@SerializedName("questionList") val questionList: ArrayList<QuestionModel>) {

}