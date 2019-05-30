package com.vivekvishwanath.android_kotlin_recyclerview

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonApiDao{
    private val BASE_URL = "https://pokeapi.co/api/v2/"
    private val SINGLE_POKEMON_URL = "pokemon/" + "%s"

    private var retrofit = Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).build()
    private var pokemonApiInterface = retrofit.create(PokemonApiInterface::class.java)
    private var gson = Gson()

    val allPokemon: AllPokemon?
    get() {
        val call = pokemonApiInterface.getAllPokemon(20)
        val allPokemonJson = call.execute().body()
        if (allPokemonJson != null) {
            val allPokemon = gson.fromJson(allPokemonJson, AllPokemon::class.java)
            return allPokemon
        }
        return null
    }

}