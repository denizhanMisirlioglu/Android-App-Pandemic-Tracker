package com.example.seniorproject
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userlist : ArrayList<country>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>()    {

    private lateinit var mListener :onItemClickListener

    private lateinit var mListener3 : onItemClickListener



    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    fun setOnItemClickListener3(listener3: onItemClickListener){

        mListener3 = listener3
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent , false )
        return MyViewHolder(itemView,mListener,mListener3)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val country : country = userlist[position]
        holder.name.text = country.location

    }

    override fun getItemCount(): Int {
        return  userlist.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener,listener3: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.tvname)

        val btnAdd : ImageButton = itemView.findViewById(R.id.btnAdd)


        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }



            btnAdd.setOnClickListener{


                listener3.onItemClick(adapterPosition)
            }






        }




    }
}