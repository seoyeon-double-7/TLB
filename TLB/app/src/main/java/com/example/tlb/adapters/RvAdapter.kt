package com.example.tlb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tlb.R

class RvAdapter(var list : ArrayList<String>,var myClick:MyInterface): RecyclerView.Adapter<RvAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun onBind(position: Int,notification : String){



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notification,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position,list[position])    }

    override fun getItemCount(): Int {
        return  list.size
    }

    interface MyInterface{
        fun onClick(position: Int,notification: String)
    }

}