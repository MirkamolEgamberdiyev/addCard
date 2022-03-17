package com.mirkamol.unicornexammodul6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexammodul6.R
import com.mirkamol.unicornexammodul6.model.CardDataItem

class CardAdapter (val context: Context, val list:ArrayList<CardDataItem>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardName = view.findViewById<TextView>(R.id.card_name)
        val cardNumber = view.findViewById<TextView>(R.id.card_number)
        val tv_data = view.findViewById<TextView>(R.id.tv_data)
       // val ll_background = view.findViewById<LinearLayout>(R.id.ll_background)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card = list[position]
        if (holder is UserViewHolder){
            holder.cardName.text = card.card_name
            holder.cardNumber.text = card.card_number
            holder.tv_data.text = card.data

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}