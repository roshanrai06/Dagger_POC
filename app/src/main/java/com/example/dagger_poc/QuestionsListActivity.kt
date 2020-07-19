package com.example.dagger_poc

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_questions_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_list)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.stackexchange.com/2.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: StackOverFlowAPI =
            retrofit.create<StackOverFlowAPI>(StackOverFlowAPI::class.java)

        text.setOnClickListener {
            val call = service.lastActiveQuestions(2)
            call?.enqueue(object : Callback<QuestionsListResponseSchema?> {
                override fun onFailure(call: Call<QuestionsListResponseSchema?>, t: Throwable) {
                    Log.d("Failure", t.message)

                }

                override fun onResponse(
                    call: Call<QuestionsListResponseSchema?>,
                    response: Response<QuestionsListResponseSchema?>
                ) {
                    Log.d("Response", response.message())
                }

            })


        }


    }
}