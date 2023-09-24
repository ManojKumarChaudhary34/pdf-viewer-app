package com.example.readpdfbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.readpdfbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bookTitle= intent.getStringExtra("book_title").toString()
        val bookDesc= intent.getStringExtra("book_desc").toString()
        val bookPdf= intent.getStringExtra("bookPdf").toString()
        val bookImg= intent.getIntExtra("book_img", 0)

        binding.apply {
            mBookImage.setImageResource(bookImg)
            mBookTitle.text= bookTitle
            mBookDesc.text= bookDesc

            mBtnRead.setOnClickListener {
                val intent= Intent()
                intent.putExtra("book_pdf", bookPdf)
                intent.setClass(this@DetailsActivity, PdfActivity::class.java)
                startActivity(intent)
            }

            mBookAudio.setOnClickListener {
                Toast.makeText(this@DetailsActivity,"Audio will be added soon...", Toast.LENGTH_SHORT).show()
            }
        }

    }
}