package com.hfad.motivation

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val  c: Context, var userList:ArrayList<Quote>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val v: View): RecyclerView.ViewHolder(v) {

        /*private val differCallBack = object : DiffUtil.ItemCallback<Quote>(){
            override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.userQuote == newItem.userQuote
            }

            override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
                return oldItem == newItem
            }

        }
        val differ = AsyncListDiffer(this, differCallBack)*/
        var title:TextView
        var content:TextView
        var menus:ImageView


        init {
             title = v.findViewById<TextView >(R.id.quote_title)
             content = v.findViewById<TextView>(R.id.quote_texts)
             menus = v.findViewById(R.id.menu_icon)
            menus.setOnClickListener { popupMenus(it) }
        }


        private fun popupMenus(v:View) {
            val position = userList[adapterPosition]
            val popupMenus = PopupMenu(c,v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.edit_text ->{
                        val v = LayoutInflater.from(c).inflate(R.layout.add_dialog, null)
                        val name =v.findViewById<EditText>(R.id.user)
                        val number = v.findViewById<EditText>(R.id.userInput)
                            AlertDialog.Builder(c)
                                .setView(v)
                                .setPositiveButton("Ok"){
                                    dialog, _ ->
                                    position.title = name.text.toString()
                                    position.userQuote = number.text.toString()

                                    notifyDataSetChanged()
                                    Toast.makeText(c, "Edit Successful", Toast.LENGTH_SHORT).show()
                                    dialog.dismiss()
                                }
                                .setNegativeButton("Cancel"){
                                    dialog, _ ->
                                    dialog.dismiss()
                                }
                                .create()
                                .show()
                        true
                    }
                    R.id.delete_text ->{
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.baseline_warning_24)
                            .setMessage("Are you sure you want to delete this Quote")
                            .setPositiveButton("Sure"){
                                dialog, _ ->
                                userList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Quote deleted", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No"){
                                dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true

                    }
                    else -> true
                }

            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.add_list, parent, false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.title.text = newList.title
        holder.content.text = newList.userQuote
    }





}