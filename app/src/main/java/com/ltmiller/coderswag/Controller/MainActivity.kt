package com.ltmiller.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ltmiller.coderswag.Adapters.CategoryRecycleAdapter
import com.ltmiller.coderswag.R
import com.ltmiller.coderswag.Services.DataService
import com.ltmiller.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }

        categoriesListView.adapter = adapter

        val layoutManger = LinearLayoutManager(this)

        categoriesListView.layoutManager = layoutManger
        categoriesListView.setHasFixedSize(true)

    }
}

