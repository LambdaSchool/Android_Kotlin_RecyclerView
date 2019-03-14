package dev.vespertine.recyclerview.RecyclerViewAdapter

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import dev.vespertine.recyclerview.Dao.NoKeyNoShadeDAO
import dev.vespertine.recyclerview.Model.DragQueen
import dev.vespertine.recyclerview.R


class DragQueenListAdapter(val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val queenList = mutableListOf<DragQueen>()

    class DragQueenItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val queenImage: ImageView = view.findViewById(R.id.searched_queen_image)
        val queenName: TextView = view.findViewById(R.id.searched_queen_name)
        val queenWin: TextView = view.findViewById(R.id.searched_queen_winner)
        val queenCongen: TextView = view.findViewById(R.id.searched_queens_misscongeniality)
        val queenQuote: TextView = view.findViewById(R.id.searched_queens_quote)
    }

    init {
        for (i in 0..10) {
            NoKeyNoShadeDAO.getQueens(object : NoKeyNoShadeDAO.QueensCallback {
                override fun callBack(dragQueen: List<DragQueen>) {
                    queenList.addAll(dragQueen)
                    activity.runOnUiThread { notifyDataSetChanged() }
                }
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.queen_list_element_layout, parent, false)
        return DragQueenItemViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        val queen = queenList[index]
        val queenHolder = viewHolder as DragQueenItemViewHolder
        queenHolder.queenName.text = "Name: " + queen.name
        queenHolder.queenQuote.text = "Quote: " + queen.quote
        queenHolder.queenWin.text = "Winnner? " + queen.winner.toString()
        queenHolder.queenCongen.text = "Miss Congeniality? " + queen.missCongeniality.toString()
        Picasso.get()
            .load(queen.image_url)
            .into(queenHolder.queenImage)
    }

    override fun getItemCount(): Int {
        return queenList.size
    }
}