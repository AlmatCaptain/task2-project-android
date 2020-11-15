package kz.iitu.bus.app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.iitu.bus.app.model.Bus

@Dao
interface BusDao {

    @Insert
    fun insertBus(bus: Bus)

    @Query("SELECT * FROM bus")
    fun getItems(): List<Bus>

    @Query("SELECT * FROM bus WHERE direct =:direct")
    fun getItems(direct: String?): List<Bus>
}