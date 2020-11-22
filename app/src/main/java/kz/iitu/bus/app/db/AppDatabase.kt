package kz.iitu.bus.app.db

import android.content.Context
import androidx.room.*
import kz.iitu.bus.app.db.dao.BusDao
import kz.iitu.bus.app.db.dao.OrderDao
import kz.iitu.bus.app.model.Bus
import kz.iitu.bus.app.model.Order

@Database(entities = [Bus::class, Order::class], version = 1)
@TypeConverters(MapConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getBusDao(): BusDao
    abstract fun getOrderDao(): OrderDao

    companion object {

        private const val DB_NAME = "bus.db"

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
            }

            return instance
        }
    }
}