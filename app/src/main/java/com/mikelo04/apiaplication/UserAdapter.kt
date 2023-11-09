package com.mikelo04.apiaplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mikelo04.apiaplication.response.ResponseModel

class UserAdapter(val datauser: ArrayList<ResponseModel>, var context: Context): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View):RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvUsername = view.findViewById<TextView>(R.id.tv_username)
        val cvmain = view.findViewById<CardView>(R.id.cv_main)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datauser.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNama.text = datauser.get(position).name
        holder.tvUsername.text = datauser.get(position).username
        holder.cvmain.setOnClickListener {
            Toast.makeText(context, ""+datauser.get(position).name, Toast.LENGTH_SHORT).show()
        }
    }

    fun setData(data: ArrayList<ResponseModel>) {
        datauser.clear()
        datauser.addAll(data)
        notifyDataSetChanged()
    }

}