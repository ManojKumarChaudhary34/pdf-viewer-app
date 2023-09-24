package com.example.readpdfbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.readpdfbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var bookList: ArrayList<BooksModel>
    private lateinit var booksAdapter: BooksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addData()
        setUpRecyclerView()
    }

    private fun addData() {
        bookList= ArrayList<BooksModel>()
        bookList.add(BooksModel(R.drawable.book_1, "Rich Dad Poor Dad", getString(R.string.description_1), "rich_dad_poor_dad.pdf"))
        bookList.add(BooksModel(R.drawable.book_2, "Atomic Habits By James Clear", getString(R.string.description_2), "book2.pdf"))
        bookList.add(BooksModel(R.drawable.book_3, "Best Selfie ", getString(R.string.description_3), "book3.pdf"))
        bookList.add(BooksModel(R.drawable.book_4, "How to be Fine", getString(R.string.description_4), "book4.pdf"))
        bookList.add(BooksModel(R.drawable.book_5, "Out of the box", getString(R.string.description_5), "book3.pdf"))
        bookList.add(BooksModel(R.drawable.book_7, "Stripped by Brenda M.", getString(R.string.description_6), "book4.pdf"))
        bookList.add(BooksModel(R.drawable.book_6, "Jordan B Peterson", getString(R.string.description_7), "book2.pdf"))
        bookList.add(BooksModel(R.drawable.book_8, "Read iSTAN", getString(R.string.description_8), "book2.pdf"))
        bookList.add(BooksModel(R.drawable.book_9, "Reclaim your Heart", getString(R.string.description_9), "book3.pdf"))
        bookList.add(BooksModel(R.drawable.book_10, "Lost Islamic History", getString(R.string.description_10), "book4.pdf"))
    }

    private fun setUpRecyclerView() {

        binding.rvHome.layoutManager= GridLayoutManager(this, 2,)
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.setItemViewCacheSize(13)
        booksAdapter= BooksAdapter(this, bookList)
        binding.rvHome.adapter= booksAdapter

    }
}