package com.jbseppanen.android_kotlin_recyclerview

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DiversionListAdapter(val activity: Activity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class DiversionItemViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val diversionNameView:TextView = view.findViewById(R.id.text_diversion_name)
        val diversionPriceView:TextView = view.findViewById(R.id.text_diversion_price)
    }

    val data = mutableListOf<Diversion>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return DiversionItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diversion_item_layout, parent, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        val element = data[index]
        val diversionHolder = viewHolder as DiversionItemViewHolder

        diversionHolder.diversionNameView.text = element.activity
        diversionHolder.diversionPriceView.text = "$ ${element.price}"
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
