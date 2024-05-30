package com.example.figmaproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.figmaproject.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var ingredientsList: ArrayList<Ingredients>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent=intent
        val selectedItem=intent.getSerializableExtra("Note") as Dishes

        binding.sekil.setImageResource(selectedItem.img2)
        binding.foodTitle.text=selectedItem.basliq
        binding.rating.text=selectedItem.star2
        binding.time.text=selectedItem.timer2
        binding.price.text=selectedItem.price2
        ingredientsList= ArrayList<Ingredients>()
        val brocolli=Ingredients(R.drawable.brocolii,"Brocolli")
        val chilli=Ingredients(R.drawable.biber,"Chilli")
        val corn2=Ingredients(R.drawable.qargidali,"Corn")
        val carrot=Ingredients(R.drawable.havuc,"Carrot")
        val brocolli2=Ingredients(R.drawable.brocolii,"Brocolli")
        val chilli2=Ingredients(R.drawable.biber,"Chilli")
        val corn3=Ingredients(R.drawable.qargidali,"Corn")

        ingredientsList.add(brocolli)
        ingredientsList.add(chilli)
        ingredientsList.add(corn2)
        ingredientsList.add(carrot)
        ingredientsList.add(brocolli2)
        ingredientsList.add(chilli2)
        ingredientsList.add(corn3)
        val layoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerIngredients.layoutManager = layoutManager3
        val ingredientsAdapter = IngredientsAdapter(ingredientsList)
        binding.recyclerIngredients.adapter = ingredientsAdapter
   binding.backButton.setOnClickListener {
       val intent = Intent(this, MainActivity::class.java)
       startActivity(intent)
   }



    }
}