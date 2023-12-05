package com.example.homework5_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            image.setImageURI(uri)
        }
    private lateinit var binding: MainActivityBinding
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = MainActivityBi
        val view = binding.root

        image.setOnClickListener {
            openGallery()
        }
    }
            private fun openGallery() {
                getContent.launch("image/*")
            }
}