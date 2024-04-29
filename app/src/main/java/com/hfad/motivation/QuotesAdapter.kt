package com.hfad.motivation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter(
    private val context: Context,
    private val quotes: MutableList<QuotesDataClass>,
    private val viewModel: FavoritesViewModel

) : RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.quotes_lists, parent, false)
        return MyViewHolder(v)
    }



    /*private val differCallBack = object: DiffUtil.ItemCallback<QuotesDataClass>(){
        override fun areItemsTheSame(oldItem: QuotesDataClass, newItem: QuotesDataClass): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: QuotesDataClass,
            newItem: QuotesDataClass
        ): Boolean {
            return oldItem == newItem
        }
    }*/

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = quotes[position]
        holder.quoteText.text = currentPosition.getQuote()
        holder.writerName.text = currentPosition.getWriter()
        holder.checkBox.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {
                onLikeClick(quotes)
                // checkbox is checked, display message saying quote added to favorites
                Toast.makeText(context,"Quotes added to favorites!", Toast.LENGTH_SHORT).show()
            } else{
                // checkbox is unchecked, display message saying quote removed from favorites
                Toast.makeText(context,"Quotes removed from favorites!", Toast.LENGTH_SHORT).show()
            }
        }
        holder.button.setOnClickListener{
            val combinedText = "${currentPosition.quotesText} - ${currentPosition.getWriter()}"
            // coppy the combined text to the clipboard
            val clipboard =context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Quote", combinedText)
            clipboard.setPrimaryClip(clip)
            // show text
            Toast.makeText(context, " copied to clipboard!", Toast.LENGTH_SHORT).show()
        }


    }


    override fun getItemCount(): Int {
        return quotes.size
    }

    private fun onLikeClick(quote: MutableList<QuotesDataClass>) {
        viewModel.addToFavorites(quote)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteText : TextView = itemView.findViewById(R.id.quote_content)
        val writerName : TextView = itemView.findViewById(R.id.writer_name)
        val checkBox: CheckBox = itemView.findViewById(R.id.heart_checkbox)
        val button:Button = itemView.findViewById(R.id.copy_btn)

    }
    


}