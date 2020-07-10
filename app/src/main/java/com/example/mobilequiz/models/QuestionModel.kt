package com.example.mobilequiz.models

import com.example.mobilequiz.models.OptionModel
import com.google.gson.annotations.SerializedName

data class QuestionModel(
    @SerializedName("idQuestion")val idQuestion: String,
    @SerializedName("questionValue") val questionValue: String,
    @SerializedName("options") val options: ArrayList<OptionModel>,
    @SerializedName("answer") val answer: String
) {


}

