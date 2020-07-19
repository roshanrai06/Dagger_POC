package com.example.dagger_poc

import com.google.gson.annotations.SerializedName

class QuestionsListResponseSchema {
    @SerializedName("items")
    private var mQuestions: List<QuestionSchema>? = null

    fun QuestionsListResponseSchema(questions: List<QuestionSchema>?) {
        mQuestions = questions
    }

    fun getQuestions(): List<QuestionSchema>? {
        return mQuestions
    }

}
