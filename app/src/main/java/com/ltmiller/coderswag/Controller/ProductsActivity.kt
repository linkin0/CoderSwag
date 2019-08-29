package com.ltmiller.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Adapter
import android.widget.GridLayout
import com.ltmiller.coderswag.Adapters.ProductsAdapter
import com.ltmiller.coderswag.R
import com.ltmiller.coderswag.Services.DataService
import com.ltmiller.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation

        if ( orientation == Configuration.ORIENTATION_LANDSCAPE ){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenHeightDp

        if ( screenSize > 720 ){
            spanCount = 3
        }

        val layoutManger = GridLayoutManager(this, spanCount)

        productsListView.layoutManager = layoutManger
        productsListView.adapter = adapter
    }
}
