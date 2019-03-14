package dev.vespertine.recyclerview.Dao

import dev.vespertine.recyclerview.Model.DragQueen
import dev.vespertine.recyclerview.Networking.NetworkAdapter
import kotlinx.serialization.json.Json

object NoKeyNoShadeDAO {

    const val ALL_QUEENS_URL = "http://www.nokeynoshade.party/api/queens/all"

    interface QueensCallback {
        fun callBack(dragQueen: DragQueen)
    }

    fun getQueens(callback: QueensCallback) {
        NetworkAdapter.httpGetRequest(ALL_QUEENS_URL, object: NetworkAdapter.NetworkCallback {
            override fun returnResult(success: Boolean?, result: String) {
                if(success == true) {
                    val queenList = Json.parse(DragQueen.serializer(), result)
                    callback.callBack(queenList)
                }

            }
        })
    }
}