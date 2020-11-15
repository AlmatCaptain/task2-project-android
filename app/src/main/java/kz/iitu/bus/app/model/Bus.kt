package kz.iitu.bus.app.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bus")
data class Bus(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "busNumber") val busNumber: String,
    @ColumnInfo(name = "direct") val direct: String,
    @ColumnInfo(name = "busBrand") val busBrand: String,
    @ColumnInfo(name = "busSeat") val busSeat: Int,
    @ColumnInfo(name = "photoUrl") val photoUrl: String,
    @ColumnInfo(name = "fromDate") val fromDate: String,
    @ColumnInfo(name = "toDate") var toDate: String,
    @ColumnInfo(name = "seatsMap") val seatsMap: Map<Int, Boolean>
) : Parcelable



