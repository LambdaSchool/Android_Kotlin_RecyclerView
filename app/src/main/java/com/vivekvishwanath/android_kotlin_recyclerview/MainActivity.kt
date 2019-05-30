package com.vivekvishwanath.android_kotlin_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson = Gson()
        val pokemonDao = PokemonApiDao()
        Thread(Runnable {
            val allPokemon = pokemonDao.allPokemon
            val i = 0
        }).start()
    }
}

const val jsonString = "{\n" +
        "  \"id\": 12,\n" +
        "  \"name\": \"butterfree\",\n" +
        "  \"base_experience\": 178,\n" +
        "  \"height\": 11,\n" +
        "  \"is_default\": true,\n" +
        "  \"order\": 16,\n" +
        "  \"weight\": 320,\n" +
        "  \"abilities\": [\n" +
        "    {\n" +
        "      \"is_hidden\": true,\n" +
        "      \"slot\": 3,\n" +
        "      \"ability\": {\n" +
        "        \"name\": \"tinted-lens\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/ability/110/\"\n" +
        "      }\n" +
        "    }\n" +
        "  ],\n" +
        "  \"forms\": [\n" +
        "    {\n" +
        "      \"name\": \"butterfree\",\n" +
        "      \"url\": \"https://pokeapi.co/api/v2/pokemon-form/12/\"\n" +
        "    }\n" +
        "  ],\n" +
        "  \"game_indices\": [\n" +
        "    {\n" +
        "      \"game_index\": 12,\n" +
        "      \"version\": {\n" +
        "        \"name\": \"white-2\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/version/22/\"\n" +
        "      }\n" +
        "    }\n" +
        "  ],\n" +
        "  \"held_items\": [\n" +
        "    {\n" +
        "      \"item\": {\n" +
        "        \"name\": \"silver-powder\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/item/199/\"\n" +
        "      },\n" +
        "      \"version_details\": [\n" +
        "        {\n" +
        "          \"rarity\": 5,\n" +
        "          \"version\": {\n" +
        "            \"name\": \"y\",\n" +
        "            \"url\": \"https://pokeapi.co/api/v2/version/24/\"\n" +
        "          }\n" +
        "        }\n" +
        "      ]\n" +
        "    }\n" +
        "  ],\n" +
        "  \"location_area_encounters\": \"https://pokeapi.co/api/v2/pokemon/132/encounters\"\n" + "," +
        "  \"moves\": [\n" +
        "    {\n" +
        "      \"move\": {\n" +
        "        \"name\": \"flash\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/move/148/\"\n" +
        "      },\n" +
        "      \"version_group_details\": [\n" +
        "        {\n" +
        "          \"level_learned_at\": 0,\n" +
        "          \"version_group\": {\n" +
        "            \"name\": \"x-y\",\n" +
        "            \"url\": \"https://pokeapi.co/api/v2/version-group/15/\"\n" +
        "          },\n" +
        "          \"move_learn_method\": {\n" +
        "            \"name\": \"machine\",\n" +
        "            \"url\": \"https://pokeapi.co/api/v2/move-learn-method/4/\"\n" +
        "          }\n" +
        "        }\n" +
        "      ]\n" +
        "    }\n" +
        "  ],\n" +
        "  \"species\": {\n" +
        "    \"name\": \"butterfree\",\n" +
        "    \"url\": \"https://pokeapi.co/api/v2/pokemon-species/12/\"\n" +
        "  },\n" +
        "  \"sprites\": {\n" +
        "    \"back_female\": \"http://pokeapi.co/media/sprites/pokemon/back/female/12.png\",\n" +
        "    \"back_shiny_female\": \"http://pokeapi.co/media/sprites/pokemon/back/shiny/female/12.png\",\n" +
        "    \"back_default\": \"http://pokeapi.co/media/sprites/pokemon/back/12.png\",\n" +
        "    \"front_female\": \"http://pokeapi.co/media/sprites/pokemon/female/12.png\",\n" +
        "    \"front_shiny_female\": \"http://pokeapi.co/media/sprites/pokemon/shiny/female/12.png\",\n" +
        "    \"back_shiny\": \"http://pokeapi.co/media/sprites/pokemon/back/shiny/12.png\",\n" +
        "    \"front_default\": \"http://pokeapi.co/media/sprites/pokemon/12.png\",\n" +
        "    \"front_shiny\": \"http://pokeapi.co/media/sprites/pokemon/shiny/12.png\"\n" +
        "  },\n" +
        "  \"stats\": [\n" +
        "    {\n" +
        "      \"base_stat\": 70,\n" +
        "      \"effort\": 0,\n" +
        "      \"stat\": {\n" +
        "        \"name\": \"speed\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/stat/6/\"\n" +
        "      }\n" +
        "    }\n" +
        "  ],\n" +
        "  \"types\": [\n" +
        "    {\n" +
        "      \"slot\": 2,\n" +
        "      \"type\": {\n" +
        "        \"name\": \"flying\",\n" +
        "        \"url\": \"https://pokeapi.co/api/v2/type/3/\"\n" +
        "      }\n" +
        "    }\n" +
        "  ]\n" +
        "}"