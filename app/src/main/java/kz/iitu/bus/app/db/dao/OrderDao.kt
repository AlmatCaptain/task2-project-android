package kz.iitu.bus.app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.iitu.bus.app.model.Order

@Dao
interface OrderDao {
    @Insert
    fun insertOrder(order: Order)

    @Query("SELECT * FROM orders")
    fun getOrders(): List<Order>
}