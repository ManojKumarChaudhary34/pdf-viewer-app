package com.example.readpdfbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.readpdfbook.databinding.HomeEachItemBinding

class BooksAdapter(private val context: Context, private val bookList: ArrayList<BooksModel>):
RecyclerView.Adapter<BooksAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= HomeEachItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            bookCoverImage.setImageResource(bookList[position].img)
            cardView.setOnClickListener {
                val intent= Intent()

                intent.putExtra("book_title", bookList[position].title)
                intent.putExtra("book_desc", bookList[position].des)
                intent.putExtra("bookPdf", bookList[position].pdf)
                intent.putExtra("book_img", bookList[position].img)
                intent.setClass(context, DetailsActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    inner class MyViewHolder(val binding: HomeEachItemBinding): RecyclerView.ViewHolder(binding.root)


}