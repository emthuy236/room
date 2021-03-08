package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.models.User

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var listuser = emptyList<User>()
    class MyViewHolder(itemView:View):  RecyclerView.ViewHolder(itemView) {

            var idtxt:TextView = itemView.findViewById(R.id.id_txt)
            var firsttxt:TextView = itemView.findViewById(R.id.firstname_txt)
            var lasttxt:TextView = itemView.findViewById(R.id.lastname_txt)
            var agetxt:TextView = itemView.findViewById(R.id.age_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listuser[position]
        holder.idtxt.text = currentItem.id.toString()
        holder.firsttxt.text = currentItem.firstName
        holder.lasttxt.text = currentItem.lastName
        holder.agetxt.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return listuser.size
    }
    fun setData(user: List<User>){
         this.listuser = user
        notifyDataSetChanged()
    }
}