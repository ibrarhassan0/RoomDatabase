package com.example.roomdatabase.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.roomdatabase.R


 class UserAdapter( private val context: Context,
                    private val listener:OnItemClicked,
                 ):Adapter<UserAdapter.ViewHolder>() {

    private val list= ArrayList<User>()
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val textview: TextView=itemView.findViewById(R.id.textView)
        var delbtn: ImageView = itemView.findViewById(R.id.delbtn)
        val button: Button =itemView.findViewById(R.id.button)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val holder= ViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem,parent,false))

        holder.delbtn.setOnClickListener {
           listener.onitemclick(list[holder.adapterPosition])
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val currentuser=list[position]
        holder.textview.text=currentuser.text


    }
     fun updataData(newuser: List<User>){
         list.clear()
         list.addAll(newuser)
         notifyDataSetChanged()
     }


}

interface OnItemClicked{
    fun onitemclick(user:User)
}

