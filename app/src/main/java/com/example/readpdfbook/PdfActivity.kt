package com.example.readpdfbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.readpdfbook.databinding.ActivityPdfBinding

class PdfActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPdfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            val bookPdf= intent.getStringExtra("book_pdf").toString()
            pdfView.fromAsset(bookPdf)
                .swipeHorizontal(true)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true)
                .load()
        }
    }
}