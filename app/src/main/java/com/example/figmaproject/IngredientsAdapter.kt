package com.example.figmaproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.figmaproject.databinding.IngredientsBinding

class IngredientsAdapter(private val ingredientsList:ArrayList<Ingredients>): RecyclerView.Adapter<IngredientsAdapter.IngredientsHolder>() {
    class IngredientsHolder(val binding: IngredientsBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsHolder {
        val binding= IngredientsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return IngredientsHolder(binding)

    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    override fun onBindViewHolder(holder: IngredientsHolder, position: Int) {
        holder.binding.ingredient.setImageResource(ingredientsList.get(position).img)
        holder.binding.name.text=ingredientsList.get(position).ad


        holder.itemView.setOnClickListener{
            val ingredientName = ingredientsList[position].ad
            val text = "$ingredientName"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(holder.itemView.context, text, duration) // in Activity
            toast.show()

        }
    }
}