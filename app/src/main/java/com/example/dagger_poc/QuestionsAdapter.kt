package com.example.dagger_poc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_question_list_item.view.*

class QuestionsAdapter(private val questionsList: List<QuestionSchema>) :
    RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_question_list_item, parent, false) as View
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.txt_title.text = questionsList[position].mTitle
    }

    class MyViewHolder(var textView: View) : RecyclerView.ViewHolder(textView)

}