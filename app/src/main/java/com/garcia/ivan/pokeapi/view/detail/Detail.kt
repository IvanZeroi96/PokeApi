package com.garcia.ivan.pokeapi.view.detail

import DetailViewModel
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.garcia.ivan.pokeapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    lateinit var viewModel: DetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val name = intent.extras?.get("name") as String

        viewModel.getDetail(name)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            nameTextView.text = pokemon.name
            weightText.text = "Peso del pokemon: ${pokemon.weight/10.0}"
            heightText.text = "Altura del pokemon: ${pokemon.height/10.0}"
            Picasso.get().load(pokemon.sprites.Other.oficialArtwork?.frontDefault).into(imageView)

        })
    }
}