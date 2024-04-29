package com.hfad.motivation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(private val context: Context, private val favoritesLists: List<QuotesDataClass>
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.favorite_list, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val quotes = favoritesLists[position]
        holder.quoteText.text = quotes.getQuote()
        holder.writerName.text = quotes.getWriter()
        holder.checkBox.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {


                // checkbox is checked, display message saying quote added to favorites
                Toast.makeText(context,"Quotes removed", Toast.LENGTH_SHORT).show()
            }
        }

    }



    override fun getItemCount(): Int {
        return favoritesLists.size
    }

    class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteText :TextView = itemView.findViewById(R.id.quote_content)
        val writerName :TextView = itemView.findViewById(R.id.writer_name)
        val checkBox:CheckBox = itemView.findViewById(R.id.heart_checkbox)

    }


}