package com.example.myapplication

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NumbersListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class NumberItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val numberView: TextView = view.findViewById(R.id.tv_number)
        val factView: TextView = view.findViewById(R.id.tv_fact)
    }

    companion object {
        const val ITEMS_PER_QUERY = 10
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }


}