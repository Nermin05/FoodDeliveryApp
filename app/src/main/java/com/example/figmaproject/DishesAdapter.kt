package com.example.figmaproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.figmaproject.databinding.DishesBinding

class DishesAdapter (private val dishesList:ArrayList<Dishes>): RecyclerView.Adapter<DishesAdapter.DishesHolder>() {
    class DishesHolder(val binding: DishesBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesHolder {
        val binding= DishesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DishesHolder(binding)

    }

    override fun getItemCount(): Int {
        return dishesList.size
    }

    override fun onBindViewHolder(holder: DishesHolder, position: Int) {
        holder.binding.krivetka.setImageResource(dishesList.get(position).img)
        holder.binding.ad.text=dishesList.get(position).name
        holder.binding.star.text=dishesList.get(position).star
        holder.binding.timer.text=dishesList.get(position).timer
        holder.binding.price.text=dishesList.get(position).price





        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,Details::class.java)
            intent.putExtra("Note",dishesList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }
}