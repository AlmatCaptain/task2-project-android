package kz.iitu.bus.app.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "busNumber") val busNumber: String,
    @ColumnInfo(name = "direct") val direct: String,
    @ColumnInfo(name = "passenger") val passenger: String,
    @ColumnInfo(name = "busSeat") val busSeat: Int,
    @ColumnInfo(name = "orderDate") val orderDate: String,
    @ColumnInfo(name = "tariff") val tariff: Int
) : Parcelable