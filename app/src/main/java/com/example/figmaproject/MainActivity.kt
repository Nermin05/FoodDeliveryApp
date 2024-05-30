package com.example.figmaproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.figmaproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesList: ArrayList<Categories>
    private lateinit var dishesList: ArrayList<Dishes>
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoriesList = ArrayList<Categories>()
        val hamburger = Categories("Burger", R.drawable.burger)
        val pizza = Categories("Pizza", R.drawable.pizosh)
        val sandwich = Categories("Sandwich", R.drawable.sosis)
        val hamburger1 = Categories("Burger", R.drawable.burger)
        val pizza1 = Categories("Pizza", R.drawable.pizosh)
        val sandwich1 = Categories("Sandwich", R.drawable.sosis)
        categoriesList.add(hamburger)
        categoriesList.add(pizza)
        categoriesList.add(sandwich)
        categoriesList.add(hamburger1)
        categoriesList.add(pizza1)
        categoriesList.add(sandwich1)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewCategories.layoutManager = layoutManager
        val categoriesAdapter = CategoriesAdapter(categoriesList)
        binding.recyclerViewCategories.adapter = categoriesAdapter

        dishesList = ArrayList<Dishes>()
        val fried = Dishes(
            "Fried Shrimp",
            R.drawable.krivetka,
            "4.8(163)",
            "20 min",
            "$29.00",
            R.drawable.krivetka,
            "Fried Shrimp",
            "4.8(163)",
            "20 min",
            "150 kcal",
            "$29.00"
        )
        val salad = Dishes(
            "Cobb salad",
            R.drawable.cobb2,
            "4.7(165)",
            "15 min",
            "$20.00",
            R.drawable.cobb2,
            "Cobb salad",
            "4.7(165)",
            "15 min",
            "100 kcal",
            "$20.00"
        )
        val corn = Dishes(
            "Corn",
            R.drawable.krivetka,
            "4.9(169)",
            "25 min",
            "$25.00",
            R.drawable.krivetka,
            "Corn",
            "4.9(169)",
            "25 min",
            "160 kcal",
            "$25.00"
        )
        val pizza2 = Dishes(
            "Pizza",
            R.drawable.cobb2,
            "5.2(170)",
            "30 min",
            "$33.00",
            R.drawable.cobb2,
            "Pizza",
            "5.2(170)",
            "30 min",
            "165 kcal",
            "$33.00"
        )

        dishesList.add(fried)
        dishesList.add(salad)
        dishesList.add(corn)
        dishesList.add(pizza2)
        val layoutManager2 = GridLayoutManager(this, 2)
        binding.recyclerViewNewDishes.layoutManager = layoutManager2
        val dishesAdapter = DishesAdapter(dishesList)
        binding.recyclerViewNewDishes.adapter = dishesAdapter

        bottomNavigationView = binding.navigation

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_bell -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.nav_grid -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.nav_heart -> {
                    replaceFragment(HeartFragment())
                    true
                }

                R.id.nav_cart -> {
                    replaceFragment(BuyFragment())
                    true
                }

                else -> false

            }

        }

            replaceFragment(HomeFragment())



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
        private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        }
    }

