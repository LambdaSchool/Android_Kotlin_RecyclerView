package com.vivekvishwanath.android_kotlin_recyclerview

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiInterface {

    @GET
    fun getPokemonByName(): Call<JsonElement>

    @GET("pokemon")
    fun getAllPokemon(@Query("limit")limit: Int): Call<JsonElement>

}