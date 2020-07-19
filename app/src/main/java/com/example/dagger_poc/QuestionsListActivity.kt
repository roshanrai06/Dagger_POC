package com.example.dagger_poc

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsListActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private var viewAdapter: QuestionsAdapter? = null
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_list)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.stackexchange.com/2.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: StackOverFlowAPI =
            retrofit.create<StackOverFlowAPI>(StackOverFlowAPI::class.java)



        viewManager = LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        // use a linear layout manager
        recyclerView.layoutManager = viewManager


        val call = service.lastActiveQuestions(2)
        call?.enqueue(object : Callback<QuestionsListResponseSchema?> {
            override fun onFailure(call: Call<QuestionsListResponseSchema?>, t: Throwable) {


            }

            override fun onResponse(
                call: Call<QuestionsListResponseSchema?>,
                response: Response<QuestionsListResponseSchema?>
            ) {
                viewAdapter = response.body()?.getQuestions()?.let { QuestionsAdapter(it) }
                recyclerView.adapter = viewAdapter
            }

        })


    }
}