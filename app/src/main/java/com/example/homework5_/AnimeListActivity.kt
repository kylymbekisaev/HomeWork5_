package com.example.homework5_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5_.databinding.ActivityAnimeListBinding

class AnimeListActivity : AppCompatActivity() {
    private val anime = mutableListOf<Anime>()
    private var binding: ActivityAnimeListBinding? = null
    private val animeAdapter = animeList_Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeListBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        fillAnimeList()
        setupRecyclerView()
    }

    private fun fillAnimeList() {
        anime.apply {
            add(Anime(R.drawable.naruto,"Naruto"))
            add(Anime(R.drawable.naruto,"Naruto"))
            add(Anime(R.drawable.naruto,"Naruto"))
            add(Anime(R.drawable.naruto,"Naruto"))
        }
    }

    private fun setupRecyclerView() {
        binding?.Recycler1?.adapter = animeAdapter
        animeAdapter.setData(anime)
    }
}