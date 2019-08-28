package com.ltmiller.coderswag.Services

import com.ltmiller.coderswag.Model.Category
import com.ltmiller.coderswag.Model.Product

object DataService {

    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HODDIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage"),
        Category("SHIRTS", "shirtimage"),
        Category("HODDIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie", "$18", "hat1"),
        Product("Devslopses Hat Black", "$20", "hat2"),
        Product("Devslopes Hat White", "$18", "hat3"),
        Product("Devslopes Hat Snapback", "$22", "hat4")
    )

    val hoodies = listOf(
        Product("Devslopes Hoodie Grey", "$28", "hoodie1"),
        Product("Devslopses Hoodie Red", "$32", "hoodie2"),
        Product("Devslopes Grey Hoodie", "$28", "hoodie3"),
        Product("Devslopes Black Hoodie", "$32", "hoodie4")
    )

    val shirts = listOf(
        Product("Devslopes Shrit Black", "$18", "shirt1"),
        Product("Devslopses Badge Light Grey", "$20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
        Product("Devslopes Hustle", "$22", "shirt4"),
        Product("Kickflip Studios", "18", "shirt5")
    )


    val digitalGood = listOf<Product>()

    fun  getProducts(category: String) : List<Product>{

        return when(category){
            "SHIRTS" -> shirts
            "HATS" -> hats
            "HOODIES" ->  hoodies
            else -> digitalGood

        }

    }

}