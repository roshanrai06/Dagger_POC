package com.example.dagger_poc

import android.os.Bundle
import android.os.PersistableBundle

class QuestionDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.layout_question_details)
    }
}