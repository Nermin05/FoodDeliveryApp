package com.example.figmaproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.figmaproject.databinding.CategoriesBinding

class CategoriesAdapter(private val categoriesList:ArrayList<Categories>): RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {
    class CategoriesHolder(val binding: CategoriesBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val binding=CategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoriesHolder(binding)

    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.binding.imageRow.setImageResource(categoriesList.get(position).img)
        holder.binding.recyclerTextView.text=categoriesList.get(position).name



        holder.itemView.setOnClickListener{
            val categoryName = categoriesList[position].name
            val text = "$categoryName"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(holder.itemView.context, text, duration)
            toast.show()


        }


    }
}