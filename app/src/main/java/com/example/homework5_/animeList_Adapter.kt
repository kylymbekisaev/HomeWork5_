package com.example.homework5_

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework5_.databinding.ItemAnimeBinding

class animeList_Adapter : RecyclerView.Adapter<animeList_Adapter.AnimeViewHolder>() {

    private var anime = listOf<Anime>()

    fun setData(data: List<Anime>){
        anime = data
    }
    class AnimeViewHolder(private val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(anime: Anime) = with(binding) {
            ivAnime.setImageResource(anime.image)
            tvAnime.text = anime.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(anime[position])
    }

    override fun getItemCount(): Int = anime.size
}