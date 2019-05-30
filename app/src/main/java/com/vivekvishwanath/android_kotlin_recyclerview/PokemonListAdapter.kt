package com.vivekvishwanath.android_kotlin_recyclerview

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.footer_layout.view.*
import kotlinx.android.synthetic.main.pokemon_list_item.view.*
import org.w3c.dom.Text

class PokemonDiffTool(private val oldData: List<Pokemon>, private val newData: List<Pokemon>): DiffUtil.Callback() {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition].id == newData[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldData[oldItemPosition] == newData[newItemPosition]
}

class PokemonListAdapter(pokemonList: ArrayList<Pokemon>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val TAG = "PokemonListAdapter"
        private const val TYPE_FOOTER = 1
        private const val TYPE_ITEM = 2
    }

    private val data = pokemonList

    open class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val pokemonImageView: ImageView = view.pokemon_image
        val pokemonNameView: TextView = view.pokemon_name

        fun bindModel(pokemon: Pokemon){
            pokemonNameView.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.pokemon_list_item, parent, false) as View)
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ViewHolder
        Picasso.get().load(data[position].sprites?.front_default).into(itemHolder.pokemonImageView)
    }


}