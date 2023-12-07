package com.example.homework5_

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework5_.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding?.image?.setImageURI(uri)
        }

    private var numberCounter = 0
    private var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        if (savedInstanceState != null) {
            numberCounter = savedInstanceState.getInt(COUNTER_KEY)
        }

        binding?.zero?.text = numberCounter.toString()
        setupCounter()
    }

    private fun openGallery() {
        getContent.launch("image/*")
    }

    private fun setupCounter() = with(binding!!) {
        button2.setOnClickListener {
            zero.text = (++numberCounter).toString()
            if (numberCounter == 10) {
                val intent = Intent(this@MainActivity, AnimeListActivity::class.java)
                startActivity(intent)
            }
        }
        button1.setOnClickListener {
            if (numberCounter > 0) {
                zero.text = (--numberCounter).toString()
            }
        }

            .apply {
            openGallery()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, numberCounter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numberCounter = savedInstanceState.getInt(COUNTER_KEY)
    }

    companion object {
        const val COUNTER_KEY = "counter"
    }
}