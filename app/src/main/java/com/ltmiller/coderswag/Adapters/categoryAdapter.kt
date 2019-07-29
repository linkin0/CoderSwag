package com.ltmiller.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ltmiller.coderswag.Model.Category
import com.ltmiller.coderswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryView: View
        val holder: ViewHolder

        if (convertView == null){

            // inflate view to access it
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()

            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder

        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }



        val category = categories[position]

        holder.categoryName?.text = category.title

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(positiion: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }


    // class created to recycle views, instead of re-creating them
    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }


}